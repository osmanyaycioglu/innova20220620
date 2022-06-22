package com.training.javaee.person.data;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.training.javaee.person.models.Person;

@Stateless
@LocalBean
public class PersonDao {

    @PersistenceContext(unitName = "javaee")
    private EntityManager em;

    //    @PersistenceUnit(unitName = "javaee")
    //    private EntityManagerFactory entityManagerFactory;


    public void insert(final Person personParam) {
        this.em.persist(personParam);
    }

    public Person getOnePerson(final Long personId) {
        TypedQuery<Person> createQueryLoc = this.em.createQuery("select p from Person p where p.personId=?1",
                                                                Person.class);
        createQueryLoc.setParameter(1,
                                    personId);
        return createQueryLoc.getSingleResult();
    }
}
