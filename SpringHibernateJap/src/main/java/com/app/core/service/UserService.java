package com.app.core.service;

import com.app.entity.user.User;
import com.app.exception.EntityMapperException;

public interface UserService {
	
	
	public User saveUser(User user) throws EntityMapperException;

}
