package com.training.javaee.rest.error;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Error> toResponse(final ConstraintViolationException exceptionParam) {
        StringBuilder stringBuilderLoc = new StringBuilder(50);
        Set<ConstraintViolation<?>> constraintViolationsLoc = exceptionParam.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolationLoc : constraintViolationsLoc) {
            stringBuilderLoc.append(constraintViolationLoc.toString());
            stringBuilderLoc.append(" ///// ");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .header("Content-Type",
                                     MediaType.APPLICATION_JSON_VALUE)
                             .body(Error.createError()
                                        .setErrorCode(10334)
                                        .setErrorCategory(1)
                                        .setDesc(stringBuilderLoc.toString()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> toResponse(final MethodArgumentNotValidException exceptionParam) {
        StringBuilder stringBuilderLoc = new StringBuilder(50);
        List<ObjectError> allErrorsLoc = exceptionParam.getAllErrors();
        for (ObjectError constraintViolationLoc : allErrorsLoc) {
            stringBuilderLoc.append(constraintViolationLoc.toString());
            stringBuilderLoc.append(" ///// ");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .header("Content-Type",
                                     MediaType.APPLICATION_JSON_VALUE)
                             .body(Error.createError()
                                        .setErrorCode(10334)
                                        .setErrorCategory(1)
                                        .setDesc(stringBuilderLoc.toString()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> toResponse(final Exception exceptionParam) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .header("Content-Type",
                                     MediaType.APPLICATION_JSON_VALUE)
                             .body(Error.createError()
                                        .setErrorCode(50000)
                                        .setErrorCategory(5)
                                        .setDesc(exceptionParam.getMessage()));
    }

}
