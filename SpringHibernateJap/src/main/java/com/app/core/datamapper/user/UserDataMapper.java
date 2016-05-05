package com.app.core.datamapper.user;

import com.app.entity.user.User;
import com.app.exception.EntityMapperException;

public interface UserDataMapper {
	
	public User saveUser(User user) throws EntityMapperException;

}
