/**
 * 
 */
package com.lab.dropwizard.jersey.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.lab.dropwizard.jersey.entity.City;
import com.lab.dropwizard.jersey.exception.ServiceException;
import com.lab.dropwizard.jersey.hibernate.HibernateUtil;

/**
 * @author paolobonansea
 *
 */
@Component
@Qualifier("cityService")
public class CityServiceImpl implements CityService {

	private static Logger LOG = Logger.getLogger(CityService.class);

	/* (non-Javadoc)
	 * @see com.lab.jersey.service.CityService#getAll()
	 */
	@Override
	public List<City> getAll() throws ServiceException {

		Session session = null;
		try {

			session = HibernateUtil.getSession();

			Criteria criteria = session.createCriteria(City.class);

			return criteria.list();

		} catch (HibernateException ex) {
			LOG.error("error city get all: " + ex.getMessage(), ex);
			throw new ServiceException(ex);
		}
	}

	@Override
	public City getByd(Long id) throws ServiceException {
		
		try {

			 return (City)HibernateUtil.getSession()
					 .get(City.class, id);

		} catch (HibernateException ex) {
			LOG.error("error city get by id: " + ex.getMessage(), ex);
			throw new ServiceException(ex);
		}
	}

}
