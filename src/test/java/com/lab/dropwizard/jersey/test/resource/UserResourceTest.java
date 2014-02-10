/**
 * 
 */
package com.lab.dropwizard.jersey.test.resource;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.dropwizard.jersey.entity.User;
import com.sun.jersey.api.client.ClientResponse;

/**
 * @author paolobonansea
 * 
 */
public class UserResourceTest {
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception { }

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception { }

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception { }

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception { }
	
	@Test
	public void testCreate() throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		user.setName("test unit ant");
		  
		ClientResponse response;
		response = AllResourcesTest.getWebResourceInstance()
				.path("user")
				.path("create")
				.type("application/json")
				.accept(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, mapper.writeValueAsString(user));
		
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
						
	}

	@Test
	public void testGetAll() {
				
		ClientResponse response = AllResourcesTest.getWebResourceInstance()
				.path("user")
				.path("all")
				.type("application/json")
				.get(ClientResponse.class);
				
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
				
	}
	
}