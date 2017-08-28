package com.cache.common;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface Cache<K,V> {
	
	//是否启用缓存
	public boolean isEnabled();

	//获取
	public V get(Object key);
	//放入
	public V put(K key, V value);
	public V put(K key, V value, long mills);
	//移除元素
	public V remove(Object key);
	//清空
	public void clear();
	
	//缓存元素大小
	public int size();
	//缓存是否为空
	public boolean isEmpty();
	
	//是否包含key
	public boolean containsKey(Object key);
	public boolean containsValue(Object value);
	
	public Set<K> keySet();
	public Collection<V> values();
	
	public Set<java.util.Map.Entry<K, V>> entrySet();
	public void putAll(Map<? extends K, ? extends V> m);
	
}
