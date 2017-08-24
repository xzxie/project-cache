package com.cache.common;


public class CacheConnection {

	private String host;
	private int port;
	private Cache cache;
	
	public CacheConnection() {
		
	}
	
	public CacheConnection(String host, int port, Cache cache) {
		this.host = host;
		this.port = port;
		this.cache = cache;
	}
	
	public CacheConnection getConnection() {
		CacheConnectionFactory factory = CacheConnectionFactory.getFactory();
		return factory.getCacheConnection(cache.getClass());
	}
	
	
	/**
	 * getter-setter
	 */
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Cache getCache() {
		return cache;
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}

}
