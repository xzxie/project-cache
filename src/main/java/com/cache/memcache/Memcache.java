package com.cache.memcache;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

import org.apache.log4j.Logger;

import com.cache.util.Constant;
import com.cache.util.PropertiesUtil;

public class Memcache {

	protected static Logger logger = Logger.getLogger(Memcache.class);
	
	private static MemcachedClient memcachedClient = null;
	
	public static MemcachedClient getConnection() {
		String host = PropertiesUtil.getProperty(Constant.properties_file, Constant.key_memcache_host);
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(host));
		builder.setConnectionPoolSize(50);
		builder.setFailureMode(true);
		try {
			memcachedClient = builder.build();
		} catch (Exception e) {
			logger.error("Memcache connect error.", e);
		}
		return memcachedClient;
	}
}
