package com.training.javaee.aspect;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Retention(RUNTIME)
@Target({
          ElementType.TYPE,
          FIELD,
          METHOD
})
public @interface CheckProcess {

    String value();
}
