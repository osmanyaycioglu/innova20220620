package com.training.javaee.rest.error;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GeneralExpHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exceptionParam) {
        if (exceptionParam instanceof NotFoundException) {
            return Response.status(Status.NOT_FOUND)
                           .header("Content-Type",
                                   MediaType.APPLICATION_JSON)
                           .entity(Error.createError()
                                        .setErrorCode(44444)
                                        .setErrorCategory(3)
                                        .setDesc(exceptionParam.getMessage()))
                           .build();
        }
        return Response.status(Status.INTERNAL_SERVER_ERROR)
                       .header("Content-Type",
                               MediaType.APPLICATION_JSON)
                       .entity(Error.createError()
                                    .setErrorCode(50000)
                                    .setErrorCategory(5)
                                    .setDesc(exceptionParam.getMessage()))
                       .build();

    }

}
