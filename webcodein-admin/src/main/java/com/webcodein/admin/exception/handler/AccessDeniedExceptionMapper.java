package com.webcodein.admin.exception.handler;

import com.webcodein.admin.dto.RestResponse;
import com.webcodein.admin.enums.RestResponseMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.springframework.security.access.AccessDeniedException;
@Provider
public class AccessDeniedExceptionMapper implements ExceptionMapper<AccessDeniedException> {

    @Override
    public Response toResponse(AccessDeniedException e) {
        System.out.println("AccessDeniedExceptionMapper checked");
        return Response.status(Response.Status.FORBIDDEN).entity(new RestResponse(
                e.getMessage(),
                RestResponseMessage.FORBIDDEN.name())).build();
    }
}