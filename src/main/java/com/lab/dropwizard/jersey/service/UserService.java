/**
 * 
 */
package com.lab.dropwizard.jersey.service;

import java.util.List;

import com.lab.dropwizard.jersey.entity.User;
import com.lab.dropwizard.jersey.exception.ServiceException;

/**
 * @author paolobonansea
 *
 */
public interface UserService {

	public void create(User user) throws ServiceException;
	
	public List<User> getAll() throws ServiceException;
	
	public User getById(long id) throws ServiceException;

}
