package com.cache.client;

import com.cache.common.Cache;
import com.cache.common.CacheConnection;
import com.cache.common.CacheConnectionFactory;
import com.cache.common.CacheConnectionPool;

public class CacheClient {
	
	private Class<Cache<?,?>> cacheClazz;
	private CacheConnection connection;
	private CacheConnectionPool connectionPool;

	public CacheClient() {
		
	}
	
	public CacheClient(Class<Cache<?,?>> cacheClazz) {
		this.cacheClazz = cacheClazz;
	}
	
	public CacheConnection getConnection(Class<Cache<?,?>> cacheClazz) {
		CacheConnectionFactory factory = CacheConnectionFactory.getFactory();
		connection = factory.getCacheConnection(cacheClazz);
		return connection;
	}
	
	public CacheConnectionPool getConnectionPool(Class<Cache<?,?>> cacheClazz) {
		CacheConnectionFactory factory = CacheConnectionFactory.getFactory();
		connectionPool = factory.getCacheConnectionPool(cacheClazz);
		return connectionPool;
	}

	
	public Class<Cache<?, ?>> getCacheClazz() {
		return cacheClazz;
	}

	public void setCacheClazz(Class<Cache<?, ?>> cacheClazz) {
		this.cacheClazz = cacheClazz;
	}
	
}
