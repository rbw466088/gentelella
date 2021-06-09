package com.yang.school.utils.cache.impl;

import java.util.HashMap;
import java.util.Map;

import com.yang.school.utils.cache.ICache;

public class CacheImpl implements ICache {

	private Map<String,Object> map = new HashMap<String, Object>();
//	private static CacheImpl instance = new CacheImpl();	//饿汉模式
	private static volatile CacheImpl instance;	//懒汉模式
	
	private CacheImpl() {
	}
	
	/**
	 * 双检查方式，该方式在jdk1.5+上安全，jdk1.5下可能会出现问题(升级版本的懒汉模式，提供了性能)
	 * @return
	 */
//	public static synchronized CacheImpl getInstance() {
//		if(null==instance) {
//			synchronized(CacheImpl.class) {
//				if(null==instance) {
//					instance = new CacheImpl();
//				}
//			}
//		}
//		return instance;
//	}

	//懒汉+饿汉(任何jdk都有效)
	private static class CacheHelper{
		static{
			System.out.println("-----CacheHelper");
		}
		static final CacheImpl instance = new CacheImpl();
	}
	
	public static CacheImpl getInstance(){
		instance = CacheHelper.instance;
		return instance;
	}

	@Override
	public void put(String key, Object value) {
		map.put(key, value);
	}

	@Override
	public Object get(String key) {
		return map.get(key);
	}

	@Override
	public void remove(String key) {
		map.remove(map.get(key));
	}
	
	public static void main(String[] args) {
		System.out.println("第一次访问");
		ICache cache = new CacheImpl();
		cache.put("K1", "accp");
		System.out.println(cache.get("K1"));
		
		System.out.println("第二次访问");
		cache = new CacheImpl();
		System.out.println(cache.get("K1"));
	}

}
