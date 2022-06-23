package com.training.javaee.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithImpl implements ConstraintValidator<StartWith, String> {

    private StartWith anno;


    @Override
    public void initialize(StartWith anno) {
        this.anno = anno;
    }


    @Override
    public boolean isValid(String valueParam,
                           ConstraintValidatorContext contextParam) {
        return valueParam.startsWith(anno.value()[0]);
    }

}
