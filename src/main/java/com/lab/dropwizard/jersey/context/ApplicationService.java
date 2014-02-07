/**
 * 
 */
package com.lab.dropwizard.jersey.context;

import java.util.Map;

import javax.ws.rs.Path;

import org.apache.log4j.Logger;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.lab.dropwizard.jersey.exception.InvalidRequestExceptionMapper;
import com.lab.dropwizard.jersey.filter.HibernateResponseFilter;
import com.lab.dropwizard.jersey.health.TemplateHealthCheck;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * @author paolobonansea
 *
 */
public class ApplicationService extends Service<ApplicationConfiguration> {

	private static Logger LOG = Logger.getLogger(ApplicationService.class);

	public static void main(String[] args) throws Exception {
        new ApplicationService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
        bootstrap.setName("hello-world");
    }

    @Override
    public void run(ApplicationConfiguration configuration,
                    Environment environment) {
    	
    	LOG.info("init application");
    	
    	final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        
        // add check template
        environment.addHealthCheck(new TemplateHealthCheck(template));
        
        // add provider
        environment.addProvider(InvalidRequestExceptionMapper.class);
        
        environment.addFilter(new HibernateResponseFilter(), "/*");
        
        AnnotationConfigWebApplicationContext parent = new AnnotationConfigWebApplicationContext();
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        parent.refresh();
        parent.getBeanFactory().registerSingleton("configuration",configuration);
        parent.registerShutdownHook();
        parent.start();

        // the real main app context has a link to the parent context
        ctx.setParent(parent);
        ctx.register(SpringConfiguration.class);
        ctx.refresh();
        ctx.registerShutdownHook();
        ctx.start();

        // add resources
        Map<String, Object> resources = ctx.getBeansWithAnnotation(Path.class);
        for(Map.Entry<String,Object> entry : resources.entrySet()) {
        	LOG.info("loading resource " + entry.getValue());
        	environment.addResource(entry.getValue());
        }
        
        
//        UserResource userResource = new UserResource();
//        AutowireCapableBeanFactory acbFactory = ctx.getAutowireCapableBeanFactory();
//        acbFactory.autowireBean(userResource);
        
        // environment.addResource(new HelloWorldResource(template, defaultName));
        // environment.addResource(userResource);
        // environment.scanPackagesForResourcesAndProviders(PublicHomeResource.class);

    }
    
}