package com.training.javaee.person.services;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.training.javaee.person.data.PersonDao;
import com.training.javaee.person.models.EAccountStatus;
import com.training.javaee.person.models.Person;

@Singleton
@LocalBean
public class PersonProvisionService {

    @EJB
    private PersonDao personDao;

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
