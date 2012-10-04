package com.service.dao;

import java.util.Map;

import com.service.models.User;
import com.utils.wsutils.ServiceException;

public interface UserDao {

	public void add (Object object) throws ServiceException;
	public void update (String username, Map<String,String> changes) throws ServiceException;
	public void delete (String username) throws ServiceException;
	public User get (String username) throws ServiceException;
}
