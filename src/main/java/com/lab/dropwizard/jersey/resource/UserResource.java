/**
 * 
 */
package com.lab.dropwizard.jersey.resource;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lab.dropwizard.jersey.entity.User;
import com.lab.dropwizard.jersey.exception.ApplicationException;
import com.lab.dropwizard.jersey.exception.ServiceException;
import com.lab.dropwizard.jersey.service.UserService;

/**
 * @author paolobonansea
 *
 */
@Path("/user")
@Service
public class UserResource {

	@Resource
	@Qualifier("userService")
	private UserService userService;

	public UserResource() { }

	public UserResource(UserService userService) { 
		this.userService = userService;
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(@Valid User user) {
		
		try {
			
			System.out.println("resource create");
			
			userService.create(user);

			return Response.ok(user, MediaType.APPLICATION_JSON).build();

		} catch (ServiceException ex) {
			return new ApplicationException(ex.getMessage()).getResponse();			
		}	
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
				
		try {

			return Response.ok(userService.getAll()).build();			
	
		} catch (ServiceException ex) {
			return new ApplicationException(ex.getMessage()).getResponse();			
		}
	}
	
	@GET
	@Path("{id}{version:(/version/[^/]+)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") Long id, @PathParam("version") String version) {
		
		try {
		
			return Response.ok(userService.getById(id)).build();			

		} catch (ServiceException ex) {
			return new ApplicationException(ex.getMessage()).getResponse();			
		}
	}
	
}
