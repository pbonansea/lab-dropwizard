/**
 * 
 */
package com.lab.dropwizard.jersey.context;

import com.sun.jersey.api.core.PackagesResourceConfig;

/**
 * @author paolobonansea
 *
 */
public class ApplicationContext extends PackagesResourceConfig {

	public ApplicationContext() {
		super("com.example.helloworld.resources");
		System.out.println("application context");
	}
	
}
