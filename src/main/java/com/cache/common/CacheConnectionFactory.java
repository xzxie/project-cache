package com.cache.common;

public class CacheConnectionFactory {

	private static CacheConnectionFactory factory;
	
	private CacheConnectionFactory() {
		
	}
	
	public static CacheConnectionFactory getFactory() {
		synchronized (factory) {
			if (factory == null) {
				synchronized (factory) {
					factory = new CacheConnectionFactory();
				}
			}
		}
		return factory;
	}
	
	// 获取连接
	public CacheConnection getCacheConnection(Class<Cache<?,?>> cacheClazz) {
		CacheConnection conn = new CacheConnection(cacheClazz).getConnection();
		return conn;
	}
	
	// 获取连接池
	public CacheConnectionPool getCacheConnectionPool(Class<Cache<?,?>> cacheClazz) {
		CacheConnectionPool pool = new CacheConnectionPool(cacheClazz).getCacheConnectionPool();
		return pool;
	}
	
}
