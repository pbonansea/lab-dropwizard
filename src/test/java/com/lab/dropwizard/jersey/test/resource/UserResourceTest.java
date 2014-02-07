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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.dropwizard.jersey.entity.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

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
	public void testCreate() {
		
		String userJsonObject = "{}";
		
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		user.setName("");
		try {
			System.out.println(mapper.writeValueAsString(user));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		Client client = Client.create();
		
		WebResource webResource = client
				   .resource("http://localhost:8080/user/create");
		 
		 
				ClientResponse response;
				try {
					response = webResource.type("application/json")
							.accept(MediaType.APPLICATION_JSON)
					   .post(ClientResponse.class, mapper.writeValueAsString(user));
				} catch (UniformInterfaceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClientHandlerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
//		ClientResponse response = AllResourcesTest.getWebTargetServiceInstance()				
//				.path("user")
//				.path("create")
//				.accept(MediaType.APPLICATION_JSON)
//				.post(ClientResponse.class, userJsonObject);
//				.post(userJsonObject, 
//						MediaType.APPLICATION_JSON), Response.class);
				
		//assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
				
	}

	@Test
	public void testGetAll() {
				
		Client client = Client.create();
		
		WebResource webResource = client
				   .resource("http://localhost:8080/user/all");
		 
		 
		ClientResponse response = webResource.type("application/json")
						.get(ClientResponse.class);
				
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
				
	}

	
//	
//	@Test
//	public void testUpdate() {
//
//		String userJsonObject = "{ \"id\": \"4\", \"lastName\":\"last name update\",\"name\":\"test name 1\",\"cityId\":\"1\"}";
//
//		Response response = AllResourcesTest.getWebTargetServiceInstance().path("user").path("update")
//				.request(MediaType.APPLICATION_JSON)
//				.post(Entity.entity(userJsonObject, 
//						MediaType.APPLICATION_JSON), Response.class);
//
//		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
//
//	}
//	
//	@Test
//	public void testDelete() {
//
//		Response response = AllResourcesTest.getWebTargetServiceInstance().path("user").path("delete/" + 15)
//				.request()
//				.post (Entity.text("payload"), Response.class);
//
//		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
//
//	}
//	
//	@Test
//	public void testGetById() {
//
//		Response response = AllResourcesTest.getWebTargetServiceInstance().path("user/" + 2)
//				.request()
//				.get(Response.class);
//
//		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
//
//	}
//	
//	@Test
//	public void testGetAll() {
//
//		Response response = AllResourcesTest.getWebTargetServiceInstance().path("user")
//				.path("all")
//				.request()
//				.property(HttpAuthenticationFeature.HTTP_AUTHENTICATION_USERNAME, "jersey")
//				.property(HttpAuthenticationFeature.HTTP_AUTHENTICATION_PASSWORD, "123")
//				.get(Response.class);
//		
//		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
//
//	}
// 	
//	@Test
//	public void testGetByCityId() {
//
//		Response response = AllResourcesTest.getWebTargetServiceInstance().path("user")
//				.path("city/" + 1)
//				.request(MediaType.APPLICATION_JSON)
//				.get(Response.class);
//
//		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
//
//	}
//	
//	@Test
//	public void testGetByCityIdCompanyId() {
//
//		Response response = AllResourcesTest.getWebTargetServiceInstance().path("user")
//				.path("city/" + 1)
//				.path("company/" + 1)
//				.request(MediaType.APPLICATION_JSON)
//				.get(Response.class);
//
//		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
//
//	}

}