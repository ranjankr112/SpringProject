package com.aroundadvice.test;

import org.springframework.aop.framework.ProxyFactory;
import com.aroundadvice.advice.LoggingAdvice;
import com.aroundadvice.beans.Calculator;

public class AroundAdviceTest {

	public static void main(String[] args) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new Calculator());
		pf.addAdvice(new LoggingAdvice());
		
		Calculator proxy = (Calculator) pf.getProxy();
		int sum = proxy.add(10, 20);
		System.out.println("Sum : "+sum);
		
	}

}
