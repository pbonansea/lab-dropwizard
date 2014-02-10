/**
 * 
 */
package com.lab.dropwizard.jersey.filter;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import com.lab.dropwizard.jersey.hibernate.HibernateUtil;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

/**
 * @author paolobonansea
 * 
 */
public class HibernateResponseFilter implements ContainerResponseFilter {

	private static Logger LOG = Logger.getLogger(HibernateResponseFilter.class);

	@Override
	public ContainerResponse filter(ContainerRequest request,
			ContainerResponse response) {

		try {

			LOG.info("closing hibernate session");
			HibernateUtil.closeSession();

		} catch (HibernateException ex) {
			LOG.warn("hibernate cannot close the session", ex);
		}
		
		return response;
	
	}

}
