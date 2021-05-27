package com.aroundadvice.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.around.cache.Cache;

public class CacheAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();
		Object[] args = invocation.getArguments();
		String key = null;
		Object retValue = null;
		Cache cache = Cache.getInstance();
		key = methodName+"(";
		for(int i=0;i<args.length;i++) {
			if(i==0) {
				key = key + args[i];
				continue;
			}
			key = key + "," + args[i]; 
		}
		key = key + ")";
		if(cache.containsKey(key) == true) {
			retValue = cache.get(key);
			
			return retValue;
		}
		
		retValue = invocation.proceed();
		cache.put(key, retValue);
		
		return retValue;
	}

}
