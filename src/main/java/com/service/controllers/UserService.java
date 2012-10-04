package com.service.controllers;

import java.util.Map;

import com.service.dao.UserDao;
import com.service.models.User;
import com.utils.json.JSONMapper;
import com.utils.json.JSONMapperException;
import com.utils.wsutils.ServiceException;
import com.utils.wsutils.ServiceResponse;

public class UserService {

	private UserDao userDao;
	
	public String add (String request) {
		try {
			Map<String,String> req = (Map<String, String>) JSONMapper.toObject(request, Map.class);
			User user = new User(req.get("username"), req.get("password"));
			userDao.add(user);
			return ServiceResponse.getSafeServiceResponse(true, "Success");
		} catch (ServiceException e) {
			return ServiceResponse.getSafeServiceResponse(false, "failed deleting user");
		} catch (JSONMapperException e) {
			return ServiceResponse.getSafeServiceResponse(false, "invalid request");
		}
	}
	
	public String update (String request) {
		try {
			Map<String,String> req = (Map<String, String>) JSONMapper.toObject(request, Map.class);
			String username = req.get("username");
			userDao.update(username, req);
			return ServiceResponse.getSafeServiceResponse(true, "Success");
		} catch (ServiceException e) {
			return ServiceResponse.getSafeServiceResponse(false, "failed deleting user");
		} catch (JSONMapperException e) {
			return ServiceResponse.getSafeServiceResponse(false, "invalid request");
		}
	}
	
	public String delete (String username) {
		try {
			userDao.delete(username);
			return ServiceResponse.getSafeServiceResponse(true, "Success");
		} catch (ServiceException e) {
			return ServiceResponse.getSafeServiceResponse(false, "failed deleting user");
		}
	}
	
	public String get (String username) {
		try {
			User user = userDao.get(username);
			return JSONMapper.toString(user);
		} catch (ServiceException e) {
			return ServiceResponse.getSafeServiceResponse(false, "user not found");
		}
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	
}
