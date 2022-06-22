package com.training.javaee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class LocalSingletonBean
 */
@Singleton
@LocalBean
public class LocalSingletonBean implements LocalSingletonBeanLocal {

    /**
     * Default constructor. 
     */
    public LocalSingletonBean() {
        // TODO Auto-generated constructor stub
    }

}
