package com.yang.school.utils.cache;

public interface ICache {
	
	public void put(String key,Object value);
	
	public Object get(String key);
	
	public void remove(String key);
}
