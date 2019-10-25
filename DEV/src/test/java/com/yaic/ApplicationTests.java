package com.yaic;


import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yaic.servicelayer.redis.core.DefaultRedisTemplate;
import com.yaic.servicelayer.redis.utils.SerializerUtils;

import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ShardedJedis;


/**
 *±¼   
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests
{

	@Autowired
	private DefaultRedisTemplate redisTemplate;

	/**
	 *
	 */
	@Ignore
	@Test
	public void contextLoads()
	{
		System.out.println("Hello world");
	}

	/**
	 * Redisæµ‹è¯•
	 */
	@Test
	public void redisTest()
	{	
		String key = "shiro*";
		System.out.println(key);
	}

}
