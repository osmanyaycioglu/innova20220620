package com.training.javaee.person.data;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class XYZDao {

    @PersistenceContext(unitName = "javaee")
    private EntityManager em;


    public void insert(final Xyz xyzParam) {
        this.em.persist(xyzParam);
    }

}
