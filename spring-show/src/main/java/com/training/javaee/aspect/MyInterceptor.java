package com.training.javaee.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyInterceptor {

    @Around("@annotation(cp)")
    public Object interceptMethod(final ProceedingJoinPoint pjp,
                                  final CheckProcess cp) {
        try {
            String valueLoc = cp.value();
            Object proceedLoc = pjp.proceed();
            return proceedLoc;
        } catch (Throwable eLoc) {
            eLoc.printStackTrace();
        }
        return null;
    }

}
