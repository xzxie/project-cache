package com.cache.common;

import java.util.Vector;

import com.cache.util.Constant;

public class CacheConnectionPool {

	private Class<Cache<?,?>> cacheClazz;
	
	private static Vector<CacheConnection> pool;
	private static CacheConnection conn = null;
	
	public CacheConnectionPool(Class<Cache<?,?>> cacheClazz) {
		this.cacheClazz = cacheClazz;
	}
	
	public CacheConnectionPool getCacheConnectionPool() {
		if (pool == null) {
			pool = new Vector<CacheConnection>(Constant.connect_default_pool_size);
			for (int i = 0; i < Constant.connect_default_pool_size; i++) {
				CacheConnection conn = new CacheConnection(cacheClazz);
				pool.add(conn);
			}
		}
		return this;
	}
	
	public synchronized CacheConnection getConnection() {
		if (pool.size() > 0) {
			CacheConnection conn = pool.get(0);
			pool.remove(conn);
			return conn;
		}
		return null;
	}
	
	public synchronized void release() {
		pool.add(conn);
	}

}
