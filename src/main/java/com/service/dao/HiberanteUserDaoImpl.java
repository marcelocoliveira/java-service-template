package com.service.dao;

import java.util.Map;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.service.models.User;
import com.utils.wsutils.ServiceException;

public class HiberanteUserDaoImpl extends HibernateTemplate  implements UserDao{

	@Override
	public void add(Object object) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String username, Map<String, String> changes)
			throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String username) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(String username) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
