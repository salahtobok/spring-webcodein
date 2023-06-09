package com.webcodein.admin.controller;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception e) {
        System.out.println("e.getClass().getSimpleName() = " + e.getClass().getSimpleName());
        return Response.serverError().entity(e.getMessage()).build();
    }
}