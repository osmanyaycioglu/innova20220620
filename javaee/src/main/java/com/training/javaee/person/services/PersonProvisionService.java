package com.training.javaee.person.services;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.training.javaee.person.data.PersonDao;
import com.training.javaee.person.data.XYZDao;
import com.training.javaee.person.models.EAccountStatus;
import com.training.javaee.person.models.Person;

@Singleton
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class PersonProvisionService {

    @EJB
    private PersonDao personDao;

    @EJB
    private XYZDao    xyzDao;

    @Transactional(value = TxType.REQUIRED)
    // @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void activatePerson(final Person person) {
        person.setAccountStatus(EAccountStatus.ACTIVE);
        this.personDao.insert(person);
        System.out.println("PersonId : " + person.getPersonId());
    }

    public void deactivatePerson(final Long personId) {

    }

    public void suspendPerson(final Long personId) {

    }

}
