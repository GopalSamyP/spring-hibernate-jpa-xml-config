package com.app.util.mapper;

import java.util.Date;

import com.app.entity.user.User;
import com.app.model.UserModel;

public class ModelMapperUtil {
	
	public static User fromUserModelToUser(UserModel userModel){
		
		User user = new User();
			
			user.setUserName(userModel.getUserName());
			user.setPassword(userModel.getPassword());
			user.setCreatedDate(new Date());
			user.setUpdatedDate(new Date());
		
		return user;
		
	}
	
	public static UserModel fromUserToUserModel(User user){
			
		UserModel userModel = new UserModel();
				
			userModel.setUserName(user.getUserName());
			userModel.setPassword(user.getPassword());
		
		return userModel;
		
	}

}
