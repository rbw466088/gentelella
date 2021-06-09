package com.yang.school.utils.cache;

import com.yang.school.utils.cache.impl.CacheImpl;

public class CacheTest {

	public static void main(String[] args) {
//		System.out.println("第一次访问");
//		ICache cache = CacheImpl.getInstance();
//		cache.put("K1", "accp");
//		System.out.println(cache.get("K1"));
//		
//		System.out.println("第二次访问");
//		cache = CacheImpl.getInstance();
//		System.out.println(cache.get("K1"));
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				ICache cache = CacheImpl.getInstance();
				System.out.println(name+":"+cache);
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				ICache cache = CacheImpl.getInstance();
				System.out.println(name+":"+cache);
			}
		}).start();
	}
	
	
}
