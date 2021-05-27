package com.around.cache;

import java.util.HashMap;
import java.util.Map;


public class Cache {
	private static Cache instance;
	private Map<String,Object> dataMap;
	
	private Cache() {
		dataMap = new HashMap<String, Object>();
	}
	
	public static synchronized Cache getInstance() {
		if(instance == null) {
			instance = new Cache();
		}
		return instance;
	}
	public void put(String key,Object value) {
		dataMap.put(key, value);
	}
	
	public Object get(String key) {
		Object value = dataMap.get(key);
		return value;
	}
	
	public boolean containsKey(String key) {
		return dataMap.containsKey(key);
	}
	
}
