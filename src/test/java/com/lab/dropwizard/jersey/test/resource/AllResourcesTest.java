package com.lab.dropwizard.jersey.test.resource;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

//@RunWith(Suite.class)
//@SuiteClasses({
//	UserResourceTest.class,
//	CityResourceTest.class,
//	CompanyResourceTest.class,
//})
@RunWith(Suite.class)
@SuiteClasses(UserResourceTest.class)
public class AllResourcesTest {

	private static Client client;
	private static WebResource service;

	private static final String HOST = "localhost";
	private static String PORT = "8080";
	private static String DOMAIN = "lab-jersey-spring";
		
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
				
		client = Client.create();
		service = client.resource("http://" + HOST + ":" + PORT);
	
	}
	
	public static WebResource getWebTargetServiceInstance() {

		if (service == null) {
			if (client == null) {
				client = Client.create();
			}
			service = client.resource("http://" + HOST + ":" + PORT).path(DOMAIN);
		}
		
		return service;
		
	}
	
}
