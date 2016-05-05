package com.app.exception;

import org.hibernate.HibernateException;

public class ServiceException extends EntityMapperException {

	private static final long serialVersionUID = 1L;

	public ServiceException(HibernateException e) {
		super(e);
	}

}
