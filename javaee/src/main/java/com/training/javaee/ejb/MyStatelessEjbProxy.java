package com.training.javaee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class MyStatelessEjbProxy extends MyStatelessEjb {

    // private MyStatelessEjb myStatelessEjb;

    //    private MyStatelessEjbPool mPool;
    //
    //    @Override
    //    public String hello(final String nameStringParam) {
    //        MyStatelessEjb myStatelessEjb = mPool.getInstance();
    //        return myStatelessEjb.hello(nameStringParam);
    //        mPool.giveBack(myStatelessEjb);
    //    }
    //
    //    @Override
    //    public int count() {
    //        MyStatelessEjb myStatelessEjb = mPool.getInstance();
    //        return myStatelessEjb.count();
    //    }

}
