/**
 * 
 */
package com.lab.dropwizard.jersey.health;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.lab.dropwizard.jersey.hibernate.HibernateUtil;
import com.yammer.metrics.core.HealthCheck;

/**
 * @author paolobonansea
 *
 */
public class DataBaseHealthCheck extends HealthCheck {

	public DataBaseHealthCheck(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see com.yammer.metrics.core.HealthCheck#check()
	 */
	@Override
	protected Result check() throws Exception {

		try {

			Session session = HibernateUtil.getSession();
			SQLQuery query = session.createSQLQuery("select 1 from dual");
			
		 	List result = query.list();
			
		 	if (result.isEmpty()) {
	            return Result.unhealthy("not connect to the data base");	 		
		 	} else {
		        return Result.healthy();
		 	}

		} catch (HibernateException ex) {
            return Result.unhealthy("not connect to the data base - "
            		+ "error: " + ex.getMessage());	 					
		}
	}

}
