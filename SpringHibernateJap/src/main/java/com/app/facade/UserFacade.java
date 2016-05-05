package com.app.facade;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.core.service.UserService;
import com.app.entity.user.User;
import com.app.exception.ApplicationException;
import com.app.exception.EntityMapperException;
import com.app.model.UserModel;
import com.app.util.mapper.ModelMapperUtil;

public class UserFacade {
	
	
	@Autowired
	private UserService userService;

	public UserModel addUser(UserModel userModel) throws ApplicationException{
		
		User user = null;
		try{
			
			user = ModelMapperUtil.fromUserModelToUser(userModel);
			userService.saveUser(user);
		}catch(EntityMapperException e){
			throw new ApplicationException(e.getMessage(), e);
		}
		return userModel;
	}
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
