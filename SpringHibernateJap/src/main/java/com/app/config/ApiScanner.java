package com.app.config;

import org.glassfish.jersey.server.ResourceConfig;

public class ApiScanner extends ResourceConfig{

	public ApiScanner(){
		packages("com.app.rest"); //register which package contains the REST end points
	}
}
