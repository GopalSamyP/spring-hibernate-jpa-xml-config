package com.app.exception;

import org.hibernate.HibernateException;

/**
 * 
 * @author Gopalsamy
 * This EntityMapperException handles exception thrown
 * while data transaction between entity and database.  
 *
 */

public class EntityMapperException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EntityMapperException(String message){
		super(message);
	}
	
	public EntityMapperException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EntityMapperException(HibernateException e) {
		super(e.getCause().getMessage(), e);
	}
	

}
