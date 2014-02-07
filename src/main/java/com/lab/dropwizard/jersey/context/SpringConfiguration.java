/**
 * 
 */
package com.lab.dropwizard.jersey.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author paolobonansea
 *
 */
@Configuration
@ImportResource("classpath:applicationContext.xml")
@ComponentScan(basePackages={"com.lab.dropwizard.jersey.resource", 
		"com.lab.dropwizard.jersey.filter"})
// (basePackageClasses = PublicHomeResource.class)
public class SpringConfiguration {

}
