package com.cache.common;

import com.cache.localcache.LocalCache;
import com.cache.memcache.Memcache;
import com.cache.redis.RedisCache;

public class CacheConnectionFactory {

	private static CacheConnectionFactory factory;
	
	private CacheConnectionFactory() {
		
	}
	
	public static CacheConnectionFactory getFactory() {
		if (factory == null) {
			factory = new CacheConnectionFactory();
		}
		return factory;
	}
	
	private Object newInstance(Class clazz) {
		Object obj = null;
		try {
			obj = (Cache) Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	// 获取连接
	public CacheConnection getCacheConnection(Class cacheClass) {
		Cache cache = (Cache) newInstance(cacheClass);
		if (cache instanceof LocalCache) {
			return getFactory().getLocalCacheConnection((LocalCache) cache);
		} else if (cache instanceof Memcache) {
			return getFactory().getMemcacheConnection((Memcache) cache);
		} else if (cache instanceof RedisCache) {
			return getFactory().getRedisCacheConnection((RedisCache) cache);
		} else {
			return getFactory().getLocalCacheConnection((LocalCache) cache);
		}
	}
	
	// 获取连接池
	public CacheConnectionPool getCacheConnectionPool(Class cacheClass) {
		Cache cache = (Cache) newInstance(cacheClass);
		if (cache instanceof LocalCache) {
			return getFactory().getLocalCacheConnectionPool((LocalCache) cache);
		} else if (cache instanceof Memcache) {
			return getFactory().getMemcacheConnectionPool((Memcache) cache);
		} else if (cache instanceof RedisCache) {
			return getFactory().getRedisCacheConnectionPool((RedisCache) cache);
		} else {
			return getFactory().getLocalCacheConnectionPool((LocalCache) cache);
		}
	}
	
	public CacheConnection getLocalCacheConnection(LocalCache cache) {
		return null;
	}
	
	public CacheConnectionPool getLocalCacheConnectionPool(LocalCache cache) {
		return null;
	}
	
	public CacheConnection getMemcacheConnection(Memcache cache) {
		return null;
	}
	
	public CacheConnectionPool getMemcacheConnectionPool(Memcache cache) {
		return null;
	}
	
	public CacheConnection getRedisCacheConnection(RedisCache cache) {
		return null;
	}
	
	public CacheConnectionPool getRedisCacheConnectionPool(RedisCache cache) {
		return null;
	}
	
}
