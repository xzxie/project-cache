package com.cache.client;

import com.cache.common.CacheConnection;
import com.cache.common.CacheConnectionFactory;
import com.cache.common.CacheConnectionPool;

public class CacheClient {
	
	private static CacheConnection connection;
	private static CacheConnectionPool connectionPool;

	public CacheClient(String host, String port) {
		
	}
	
	public CacheClient(String host, String port, Class cacheClazz) {
		
	}
	
	public CacheConnection getConnection(Class cache) {
		return CacheConnectionFactory.getFactory().getCacheConnection(cache);
	}
	
	public CacheConnectionPool getConnectionPool(Class cache) {
		return CacheConnectionFactory.getFactory().getCacheConnectionPool(cache);
	}
	
}
