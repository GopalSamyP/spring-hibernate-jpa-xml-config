package com.app.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.app.model.UserModel;
import com.app.util.ResponseContainer;

@Path("signup")
public class SignupRest {
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseContainer signup(UserModel user){
		
		ResponseContainer response = new ResponseContainer();
		
		try{
			response.setSucMsg("hit succeess!!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return response;
		
	}

}
