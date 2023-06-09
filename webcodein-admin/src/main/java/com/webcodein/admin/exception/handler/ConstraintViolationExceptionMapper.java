package com.webcodein.admin.exception.handler;

import com.webcodein.admin.dto.RestResponse;
import com.webcodein.admin.enums.RestResponseMessage;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		System.out.println("ConstraintViolationExceptionMapper checked");
		ArrayList<ConstraintViolation<?>> constraintViolationArrayList = new ArrayList<>(exception.getConstraintViolations());
		return Response.status(Response.Status.NOT_ACCEPTABLE).entity(new RestResponse(
				constraintViolationArrayList.get(0).getMessage(),
				RestResponseMessage.CONSTRAINT_VIOLATIONS.name())).build();
	}

}
