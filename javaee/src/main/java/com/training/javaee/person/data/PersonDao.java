package com.training.javaee.person.data;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.transaction.UserTransaction;

import com.training.javaee.person.models.Person;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class PersonDao {

    @PersistenceContext(unitName = "javaee")
    private EntityManager   em;

    @Resource
    private UserTransaction uTransaction;

    @Resource(lookup = "java:jboss/datasources/ExampleDS")
    private DataSource      dataSource;

    //    @PersistenceUnit(unitName = "javaee")
    //    private EntityManagerFactory entityManagerFactory;

    @Transactional(value = TxType.REQUIRED)
    public void insert(final Person personParam) {
        this.em.persist(personParam);
    }

    @Transactional(value = TxType.REQUIRED)
    public void insertTry(final Person personParam) {
        if (this.em.contains(personParam)) {

        }
        this.em.persist(personParam);
        this.em.flush();
        this.em.detach(personParam);
        personParam.setName("deneme");
        personParam.setSurname("ala");
    }

    @Transactional
    public void update(final Person personParam) {
        if (!this.em.contains(personParam)) {
            this.em.merge(personParam);
        }
    }


    public void insertJDBC(final Person personParam) {
        try (Connection connectionLoc = this.dataSource.getConnection();
             PreparedStatement ps = connectionLoc.prepareStatement("insert into kisi (astatus, height, name, password, surname, weight, personId) values (?, ?, ?, ?, ?, ?, ?)")) {
            connectionLoc.setAutoCommit(false);
            int transactionIsolationLoc = connectionLoc.getTransactionIsolation();
            connectionLoc.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            ps.setInt(1,
                      personParam.getAccountStatus()
                                 .ordinal());
            ps.setInt(2,
                      personParam.getHeight());
            ps.setString(3,
                         personParam.getName());
            // ...
            ps.execute();
            connectionLoc.setTransactionIsolation(transactionIsolationLoc);
            connectionLoc.commit();
        } catch (Exception eLoc) {

        }
    }


    public Person getOnePerson(final Long personId) {
        TypedQuery<Person> createQueryLoc = this.em.createQuery("select p from Person p where p.personId=?1",
                                                                Person.class);
        createQueryLoc.setParameter(1,
                                    personId);
        // createQueryLoc.setLockMode(LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        return createQueryLoc.getSingleResult();
    }

    public void updateOnePersonPessimistic(final Person person) {
        Person findLoc = this.em.find(Person.class,
                                      person.getPersonId(),
                                      LockModeType.PESSIMISTIC_WRITE);
        findLoc.setHeight(300);
    }

    public void insertJava(final Person personParam) {
        try {
            this.em.getTransaction()
                   .begin();
            this.em.persist(personParam);
            this.em.getTransaction()
                   .commit();
        } catch (Exception eLoc) {
            this.em.getTransaction()
                   .rollback();
        }
    }

}
