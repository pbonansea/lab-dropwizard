package com.lab.dropwizard.jersey.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.lab.dropwizard.jersey.entity.User;
import com.lab.dropwizard.jersey.exception.ServiceException;
import com.lab.dropwizard.jersey.hibernate.HibernateUtil;

@Component
@Qualifier("userService")
public class UserServiceImpl implements UserService {

	private static Logger LOG = Logger.getLogger(UserService.class);

	@Override
	public void create(User user) throws ServiceException {

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null && tx.isActive()) {
				tx.rollback();				
			}
			LOG.error("error user create: " + ex.getMessage(), ex);
			throw new ServiceException(ex);
		} 
	}

	@Override
	public List<User> getAll() throws ServiceException {

		Session session = null;
		try {

			session = HibernateUtil.getSession();

			Criteria criteria = session.createCriteria(User.class);

			return criteria.list();

		} catch (HibernateException ex) {
			LOG.error("error user get all: " + ex.getMessage(), ex);
			throw new ServiceException(ex);
		}
	}
	
	@Override
	public User getById(long id) throws ServiceException {

		Session session = null;
		try {

			session = HibernateUtil.getSession();
			return (User) session.get(User.class, id);

		} catch (HibernateException ex) {
			LOG.error("error user get by id: " + ex.getMessage(), ex);
			throw new ServiceException(ex);
		} 
	}


}
