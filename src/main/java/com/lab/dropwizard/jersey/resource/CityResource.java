/**
 * 
 */
package com.lab.dropwizard.jersey.resource;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lab.dropwizard.jersey.exception.ApplicationException;
import com.lab.dropwizard.jersey.exception.ServiceException;
import com.lab.dropwizard.jersey.service.CityService;

/**
 * @author paolobonansea
 *
 */
@Path("/city")
@Service
public class CityResource {

	@Resource
	@Qualifier("cityService")
	private CityService cityService;

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAddresss() {

		try {
		
			return Response.ok(this.cityService.getAll()).build();

		} catch (ServiceException ex) {
			return new ApplicationException(ex.getMessage()).getResponse();
		}
	}

}
