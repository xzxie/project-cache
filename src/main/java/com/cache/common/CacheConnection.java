package com.cache.common;

import org.apache.log4j.Logger;

import com.cache.localcache.LocalCache;
import com.cache.memcache.Memcache;
import com.cache.redis.RedisCache;
import com.cache.util.Constant;


public class CacheConnection {

	protected static final Logger logger = Logger.getLogger(CacheConnection.class);
	
	private Class<Cache<?,?>> cacheClazz;
	
	public CacheConnection(Class<Cache<?,?>> cacheClazz) {
		this.cacheClazz = cacheClazz;
	}
	
	@SuppressWarnings("unchecked")
	public CacheConnection getConnection() {
		if (cacheClazz == null) {
			cacheClazz = (Class<Cache<?, ?>>) Constant.default_cache;
		}
		Cache<?,?> cache;
		try {
			cache = cacheClazz.newInstance();
			if (cache instanceof LocalCache) {
				
			} else if (cache instanceof Memcache) {
				
			} else if (cache instanceof RedisCache) {
				
			}
		} catch (Exception e) {
			logger.error("Init cache object error", e);
		}
		return this;
	}

}
