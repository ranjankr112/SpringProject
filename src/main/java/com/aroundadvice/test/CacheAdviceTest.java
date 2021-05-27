package com.aroundadvice.test;

import org.springframework.aop.framework.ProxyFactory;

import com.aroundadvice.advice.CacheAdvice;
import com.aroundadvice.advice.LoggingAdvice;
import com.aroundadvice.beans.Calculator;

public class CacheAdviceTest {

	public static void main(String[] args) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new Calculator());
		
		pf.addAdvice(new LoggingAdvice());
		pf.addAdvice(new CacheAdvice());
		
		
		Calculator proxy = (Calculator) pf.getProxy();
		int sum1 = proxy.add(10, 20);
		System.out.println(sum1);
		int sum2 = proxy.add(10, 20);
		System.out.println(sum2);
	}

}
