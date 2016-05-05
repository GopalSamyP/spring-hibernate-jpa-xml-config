package com.app.core.service.impl;

import com.app.core.datamapper.user.UserDataMapper;
import com.app.core.service.UserService;
import com.app.entity.user.User;
import com.app.exception.EntityMapperException;
import com.app.exception.ServiceException;

public class UserServiceImpl implements UserService {

	private UserDataMapper userDataMapper;
	
	@Override
	public User saveUser(User user) throws EntityMapperException {
		
		try{
			
			return userDataMapper.saveUser(user);
		
		}catch(ServiceException e){
			e.printStackTrace();
		}
		return null;
	}

	public void setUserDataMapper(UserDataMapper userDataMapper) {
		this.userDataMapper = userDataMapper;
	}

}
