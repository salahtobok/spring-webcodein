package com.webcodein.admin.exception.handler;

import com.webcodein.admin.dto.RestResponse;
import com.webcodein.admin.enums.RestResponseMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception exception) {
        System.out.println("GenericExceptionMapper checked");
        return Response.status(Response.Status.BAD_REQUEST).entity(new RestResponse(
                exception.getMessage(),
                exception.getCause().getMessage())).build();
    }
}