/**
 * 
 */
package com.lab.dropwizard.jersey.service;

import java.util.List;

import com.lab.dropwizard.jersey.entity.City;
import com.lab.dropwizard.jersey.exception.ServiceException;

/**
 * @author paolobonansea
 *
 */
public interface CityService {

	public List<City> getAll() throws ServiceException;
	
	public City getByd(Long id) throws ServiceException;
	
}
