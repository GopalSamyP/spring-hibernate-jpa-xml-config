package com.app.core.datamapper.user;

import org.hibernate.HibernateException;

import com.app.core.datamapper.HibernateDataMapper;
import com.app.entity.user.User;
import com.app.exception.EntityMapperException;

public class UserDataMapperImpl extends HibernateDataMapper<User> implements UserDataMapper  {

	@Override
	public Class<?> setEntityClass() {
		return User.class;
	}

	@Override
	public User saveUser(User user) throws EntityMapperException {
		
		try {
			
			this.save(user);
			return user;
			
		}catch(HibernateException e){
			e.printStackTrace();
			throw new EntityMapperException(e);
			
		}
	}
	
	
}
