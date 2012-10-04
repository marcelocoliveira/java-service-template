package com.service.dao;

import java.util.Map;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;
import com.service.models.User;
import com.utils.wsutils.ServiceException;


public class MongoDBUserDaoImpl  implements UserDao {

	private MongoTemplate mongoTemplate;
	
	@Override
	public void add(Object object) throws ServiceException {
		mongoTemplate.save(object);
		
	}

	@Override
	public void update(String username, Map<String,String> changes) throws ServiceException {
		Query query = new Query(Criteria.where("username").is(username));
		for (Map.Entry<String, String> m :changes.entrySet()){
			WriteResult result = mongoTemplate.updateMulti(query,Update.update(m.getKey(), m.getValue()), "users");
			if (!result.getLastError().ok()) throw new ServiceException(result.getError());
		}
	}

	@Override
	public void delete(String username) throws ServiceException {
		mongoTemplate.remove(new Query(
                Criteria.where("username").is(username)
            ), "users");
	}

	@Override
	public User get(String username) throws ServiceException {
		User user = mongoTemplate.findOne(
				new Query(Criteria.where("username").is(username)
		                ), User.class,"users"
		          );
		return user;
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	
	
}
