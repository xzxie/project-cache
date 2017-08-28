package com.cache.redis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.cache.util.Constant;
import com.cache.util.PropertiesUtil;


public class RedisCache {

	protected static Logger logger = Logger.getLogger(RedisCache.class);
	
	private static Jedis jedis;	// 非切片连接
	private static JedisPool jedisPool;	// 非切片连接池
	private static ShardedJedis shardedJedis; // 切片连接
	private static ShardedJedisPool shardedJedisPool; // 切片连接池
	
	public static Jedis getConnection() {
		String host = PropertiesUtil.getProperty(Constant.properties_file, Constant.key_rediscache_host);
		jedis = new Jedis(host, Constant.redis_default_port);
		return jedis;
	}
	
	public static Jedis getConnectionFromPool() {
		jedis = jedisPool.getResource();
		return jedis;
	}
	
	public static ShardedJedis getConnectionSharded() {
		String host = PropertiesUtil.getProperty(Constant.properties_file, Constant.key_rediscache_host);
		String[] hosts = host.split(Constant.space);
		JedisShardInfo[] shardInfo = new JedisShardInfo[hosts.length];
		for (int i = 0; i < hosts.length; i++) {
			shardInfo[i] = new JedisShardInfo(hosts[i], Constant.redis_default_port, 500);
		}
		shardedJedis = new ShardedJedis(Arrays.asList(shardInfo));
		return shardedJedis;
	}
	
	// 基本池
	public static JedisPool getConnectionPool() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(20);
		poolConfig.setMaxIdle(5);
		poolConfig.setMaxWaitMillis(1000);
		poolConfig.setTestOnBorrow(false);
		String host = PropertiesUtil.getProperty(Constant.properties_file, Constant.key_rediscache_host);
		jedisPool = new JedisPool(poolConfig, host, Constant.redis_default_port);
		return jedisPool;
	}
	
	// 切片池
	public static ShardedJedisPool getConnectionShardPool() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(20);
		poolConfig.setMaxIdle(5);
		poolConfig.setMaxWaitMillis(1000);
		poolConfig.setTestOnBorrow(false);
		String host = PropertiesUtil.getProperty(Constant.properties_file, Constant.key_rediscache_host);
		// slave链接
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		shards.add(new JedisShardInfo(host, Constant.redis_default_port, "master"));
		// 构造池
		shardedJedisPool = new ShardedJedisPool(poolConfig, shards);
		return shardedJedisPool;
	}
	
	public static void release(JedisPool jedisPool, Jedis jedis) {
		jedisPool.returnResource(jedis);
	}
	
	public static void release(ShardedJedisPool shardedJedisPool, ShardedJedis shardedJedis) {
		shardedJedisPool.returnResource(shardedJedis);
	}
}
