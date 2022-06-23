package com.training.javaee.person.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.javaee.person.data.PersonDao;
import com.training.javaee.person.models.EAccountStatus;
import com.training.javaee.person.models.Person;

@Service
//@Singleton
//@LocalBean
//@TransactionManagement(TransactionManagementType.BEAN)
public class PersonProvisionService {

    @Autowired
    private PersonDao personDao;

    @Transactional(propagation = Propagation.REQUIRED)
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
