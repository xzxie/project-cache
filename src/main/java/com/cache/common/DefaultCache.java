package com.cache.common;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class DefaultCache<K,V> implements Cache<K,V> {

	public boolean isEnabled() {
		return true;
	}
	
	public void clear() {
		
	}

	public boolean containsKey(Object key) {
		return false;
	}

	public boolean containsValue(Object value) {
		return false;
	}

	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return null;
	}

	public V get(Object key) {
		return null;
	}

	public boolean isEmpty() {
		return false;
	}

	public Set<K> keySet() {
		return null;
	}

	public V put(K key, V value) {
		return null;
	}
	
	public V put(K key, V value, long mills) {
		return null;
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		
	}

	public V remove(Object key) {
		return null;
	}

	public int size() {
		return 0;
	}

	public Collection<V> values() {
		return null;
	}

}
