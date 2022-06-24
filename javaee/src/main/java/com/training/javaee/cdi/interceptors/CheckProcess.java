package com.training.javaee.cdi.interceptors;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;


@Retention(RUNTIME)
@Target({
          ElementType.TYPE,
          FIELD,
          METHOD
})
@InterceptorBinding
public @interface CheckProcess {

}
