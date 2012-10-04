package com.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.service.controllers.UserService;
import com.utils.logging.MyLogger;

@Path("user")
public class UserWsApi {
	
	private static MyLogger logger = new MyLogger(UserWsApi.class);
	private UserService userService;
	
	
	@POST
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String add (String paylaod)  {
		logger.logInfo("list resources service:");
		return userService.add(paylaod);
	}
	
	@POST
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String update (String paylaod)  {
		logger.logInfo("list resources service:");
		return userService.add(paylaod);
	}
	
	@GET
	@Path("get/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public String get (@PathParam("username") String username)  {
		logger.logInfo("list resources service:");
		return userService.get(username);
	}
	
	@GET
	@Path("delete/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public String delete (@PathParam("username") String username)  {
		logger.logInfo("list resources service:");
		return userService.get(username);
	}

	public static MyLogger getLogger() {
		return logger;
	}

	public static void setLogger(MyLogger logger) {
		UserWsApi.logger = logger;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
}
