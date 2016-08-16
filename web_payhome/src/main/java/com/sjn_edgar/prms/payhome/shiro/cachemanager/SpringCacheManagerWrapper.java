package com.sjn_edgar.prms.payhome.shiro.cachemanager;/*
* Copyright (c) 2016 www.51cjhb.com. All Rights Reserved.
*/

import net.sf.ehcache.Ehcache;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.*;

/**
 * <p>Title:shiro 缓存管理器类 </p>
 * <p>Description: 包装Spring cache抽象. </p>
 *
 * @author edgar 【zbo@51qmz.cn】
 * @version 1.0
 * @create 2016 08 16 17:29
 */
public class SpringCacheManagerWrapper implements CacheManager{

	private org.springframework.cache.CacheManager cacheManager;

	/**
	 * 设置spring cachemanager manager
	 * @param cacheManager
	 */
	public void setCacheManager(org.springframework.cache.CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	/**
	 * 获取缓存 （重新父类方法）
	 * @param name
	 * @param <K>
	 * @param <V>
	 * @return
	 * @throws CacheException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		org.springframework.cache.Cache springCache = cacheManager.getCache(name);
		return new SpringCacheWrapper(springCache);
	}

	@SuppressWarnings("rawtypes")
	static class SpringCacheWrapper implements Cache {
		private org.springframework.cache.Cache springCache;

		SpringCacheWrapper(org.springframework.cache.Cache springCache) {
			this.springCache = springCache;
		}

		@Override
		public Object get(Object key) throws CacheException {
			Object value = springCache.get(key);
			if (value instanceof SimpleValueWrapper) {
				return ((SimpleValueWrapper) value).get();
			}
			return value;
		}

		@Override
		public Object put(Object key, Object value) throws CacheException {
			springCache.put(key, value);
			return value;
		}

		@Override
		public Object remove(Object key) throws CacheException {
			springCache.evict(key);
			return null;
		}

		@Override
		public void clear() throws CacheException {
			springCache.clear();
		}

		@Override
		public int size() {
			if (springCache.getNativeCache() instanceof Ehcache) {
				Ehcache ehcache = (Ehcache) springCache.getNativeCache();
				return ehcache.getSize();
			}
			throw new UnsupportedOperationException("invoke spring cachemanager abstract size method not supported");
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set keys() {
			if (springCache.getNativeCache() instanceof Ehcache) {
				Ehcache ehcache = (Ehcache) springCache.getNativeCache();
				return new HashSet(ehcache.getKeys());
			}
			throw new UnsupportedOperationException("invoke spring cachemanager abstract keys method not supported");
		}

		@SuppressWarnings("unchecked")
		@Override
		public Collection values() {
			if (springCache.getNativeCache() instanceof Ehcache) {
				Ehcache ehcache = (Ehcache) springCache.getNativeCache();
				List keys = ehcache.getKeys();
				if (!CollectionUtils.isEmpty(keys)) {
					List values = new ArrayList(keys.size());
					for (Object key : keys) {
						Object value = get(key);
						if (value != null) {
							values.add(value);
						}
					}
					return Collections.unmodifiableList(values);
				} else {
					return Collections.emptyList();
				}
			}
			throw new UnsupportedOperationException("invoke spring cachemanager abstract values method not supported");
		}
	}


}
