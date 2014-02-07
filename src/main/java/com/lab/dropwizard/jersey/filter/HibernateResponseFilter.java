/**
 * 
 */
package com.lab.dropwizard.jersey.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import com.lab.dropwizard.jersey.hibernate.HibernateUtil;

/**
 * @author paolobonansea
 *
 */
public class HibernateResponseFilter implements Filter {
	
	private static Logger LOG = Logger.getLogger(HibernateResponseFilter.class);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		try {
			
			LOG.info("closing hibernate session");
			HibernateUtil.closeSession();

		} catch (HibernateException ex) {
			LOG.error("hibernate cannot close the session", ex);
		}
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
