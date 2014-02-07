/**
 * 
 */
package com.lab.dropwizard.jersey.resource;

import com.google.common.base.Optional;
import com.lab.dropwizard.jersey.entity.Saying;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author paolobonansea
 *
 */
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
@Service
public class HelloWorldResource {
	
	private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    
    public HelloWorldResource() {
        this.template = "hello";
        this.defaultName = "hello";
        this.counter = new AtomicLong();    	
    }
    
    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        return new Saying(counter.incrementAndGet(),
                          String.format(template, name.or(defaultName)));
    }
     
}
