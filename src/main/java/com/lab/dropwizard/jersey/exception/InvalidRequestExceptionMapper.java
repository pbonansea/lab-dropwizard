/**
 * 
 */
package com.lab.dropwizard.jersey.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.eclipse.jetty.http.HttpStatus;

import com.yammer.dropwizard.validation.InvalidEntityException;

/**
 * @author paolobonansea
 * 
 */
@Provider
public class InvalidRequestExceptionMapper implements
		ExceptionMapper<InvalidEntityException> {

	@Override
	public Response toResponse(InvalidEntityException e) {

		HttpErrorBean error = new HttpErrorBean();
		error.setHttpStatus(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY_422));
		error.setCode(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY_422));
		error.setMessage(e.getMessage());

		return Response.status(HttpStatus.UNPROCESSABLE_ENTITY_422).type(MediaType.APPLICATION_JSON)
				.entity(error).build();

	}
}