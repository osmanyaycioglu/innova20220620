package com.training.javaee.rest.error;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintErrorHandler2 implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exceptionParam) {
        StringBuilder stringBuilderLoc = new StringBuilder(50);
        Set<ConstraintViolation<?>> constraintViolationsLoc = exceptionParam.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolationLoc : constraintViolationsLoc) {
            stringBuilderLoc.append(constraintViolationLoc.toString());
            stringBuilderLoc.append(" ///// ");
        }
        return Response.status(Status.BAD_REQUEST)
                       .header("Content-Type",
                               MediaType.APPLICATION_JSON)
                       .entity(Error.createError()
                                    .setErrorCode(10334)
                                    .setErrorCategory(1)
                                    .setDesc(stringBuilderLoc.toString()))
                       .build();
    }

}
