package com.cache.common;

import java.io.Serializable;

public class CacheInfo implements Serializable {

	private static final long serialVersionUID = 4750094269285018379L;

	private String key;			// 键
	private Object value;		// 值
	private long timestamp;		// 更新时间
	private int duration;		// 有效时长
	private boolean isExpired;	// 是否过期
	
	public CacheInfo() {
		
	}
	
	public CacheInfo(String key, Object value, long timestamp, boolean isExpired) {
		this.key = key;
		this.value = value;
		this.timestamp = timestamp;
		this.isExpired = isExpired;
	}
	
	public CacheInfo(String key, Object value, long timestamp, int duration, boolean isExpired) {
		this.key = key;
		this.value = value;
		this.timestamp = timestamp;
		this.duration = duration;
		this.isExpired = isExpired;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	
}
