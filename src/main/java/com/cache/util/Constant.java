package com.cache.util;

import com.cache.localcache.LocalCache;

public class Constant {

	public static final String space = " ";
	
	public static Class<?> default_cache = LocalCache.class;
	public static final Integer connect_default_pool_size = 200;
	public static final Integer memcache_default_port = 11211;
	public static final Integer redis_default_port = 6379;
	
	public static final String properties_file = "cache.properties";
	public static final String key_memcache_host = "memcache_host";
	public static final String key_rediscache_host = "rediscache_host";
}
