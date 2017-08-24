package com.cache.localcache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SimpleConcurrentMap<K,V> implements Map<K,V> {

	public final ReadWriteLock lock = new ReentrantReadWriteLock();
	public final Lock rlock = lock.readLock();
	public final Lock wlock = lock.writeLock();
	public final Map<K,V> map;
	
	public SimpleConcurrentMap(Map<K,V> map) {
		this.map = map;
		if (map == null) {
			throw new NullPointerException();
		}
	}
	
	public void clear() {
		wlock.lock();
		try {
			map.clear();
		} finally {
			wlock.unlock();
		}
	}
	
	public boolean containsKey(Object key) {
		rlock.lock();
		try {
			return map.containsKey(key);
		} finally {
			rlock.unlock();
		}
	}
	
	public boolean containsValue(Object value) {
		rlock.lock();
		try {
			return map.containsValue(value);
		} finally {
			rlock.unlock();
		}
	}
	
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		throw new UnsupportedOperationException();
	}
	
	public V get(Object key) {
		rlock.lock();
		try {
			return map.get(key);
		} finally {
			rlock.unlock();
		}
	}
	
	public boolean isEmpty() {
		rlock.lock();
		try {
			return map.isEmpty();
		} finally {
			rlock.unlock();
		}
	}
	
	public Set<K> keySet() {
		rlock.lock();
		try {
			return new HashSet<K>(map.keySet());
		} finally {
			rlock.unlock();
		}
	}
	
	public V put(K key, V value) {
		wlock.lock();
		try {
			return map.put(key, value);
		} finally {
			wlock.unlock();
		}
	}
	
	public void putAll(Map<? extends K, ? extends V> m) {
		wlock.lock();
		try {
			map.putAll(m);
		} finally {
			wlock.unlock();
		}
	}
	
	public V remove(Object key) {
		wlock.lock();
		try {
			return map.remove(key);
		} finally {
			wlock.unlock();
		}
	}
	
	public int size() {
		rlock.lock();
		try {
			return map.size();
		} finally {
			rlock.unlock();
		}
	}
	
	public Collection<V> values() {
		rlock.lock();
		try {
			return new ArrayList<V>(map.values());
		} finally {
			rlock.unlock();
		}
	}
}
