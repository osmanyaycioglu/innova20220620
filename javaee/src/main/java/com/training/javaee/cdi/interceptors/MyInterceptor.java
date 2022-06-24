package com.training.javaee.cdi.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@CheckProcess
public class MyInterceptor {

    @AroundInvoke
    public Object interceptMethod(final InvocationContext contextParam) {
        try {
            String methodNameLoc = contextParam.getMethod()
                                               .getName();
            Class<?> declaringClassLoc = contextParam.getMethod()
                                                     .getDeclaringClass();
            Object[] parametersLoc = contextParam.getParameters();
            if (!parametersLoc[0].equals("osman")) {
                Object[] newParametersLoc = new Object[parametersLoc.length];
                newParametersLoc[0] = parametersLoc[0] + " girdi değiştirdim.";
                contextParam.setParameters(newParametersLoc);
                long nanoTimeLoc = System.nanoTime();
                Object proceedLoc = contextParam.proceed();
                System.out.println(methodNameLoc
                                   + " method Delta : "
                                   + (System.nanoTime() - nanoTimeLoc)
                                   + " class : "
                                   + declaringClassLoc.getName());
                if (proceedLoc instanceof String) {
                    return proceedLoc + " intercepted!.";
                }
            } else {
                return "Training interceptor";
            }
        } catch (Throwable eLoc) {
            eLoc.printStackTrace();
        }
        return null;
    }

}
