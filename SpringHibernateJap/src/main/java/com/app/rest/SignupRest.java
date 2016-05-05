package com.app.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.facade.UserFacade;
import com.app.model.UserModel;
import com.app.util.ResponseContainer;

@Path("signup")
public class SignupRest {
	
	@Autowired
	private UserFacade userFacade;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseContainer signup(UserModel userModel){
		
		final Logger logger = LogManager.getLogger(SignupRest.class);
		
		ResponseContainer response = new ResponseContainer();
		
		try{
	        
			userFacade.addUser(userModel);
			response.setSucMsg("hit succeess!!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return response;
		
	}

}
