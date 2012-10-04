package com.redis;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;

import com.service.redis.ObjectRepository;

public class RedisTest extends TestCase {

	/**
	 * @param args
	 */
	public void testRedisKeyValue () {
		ApplicationContext context  = BeanInit.getContext();
		ObjectRepository objectRepository =  (ObjectRepository) context.getBean("objectRepository");
		objectRepository.add("marcelo", "test123");
		String value = objectRepository.getValue("marcelo");
		Assert.assertEquals( value , "test123");

	}

}
