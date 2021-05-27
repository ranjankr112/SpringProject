package com.aroundadvice.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();
		Object[] args = invocation.getArguments();
		boolean allZeroArgs = true;
		
		System.out.print("entered into "+methodName+"(");
		for(int i=0;i<args.length;i++) {
			if(i == 0) {
				System.out.print(args[i]);
				continue;
			}
			System.out.print(","+args[i]);
		}
		System.out.println(")");
		
		args[0] = (Integer)args[0] + 10;
		args[1] = (Integer)args[1] + 10;
		Object retValue = invocation.proceed();
		System.out.println("exiting from "+methodName+"with ret "+retValue);
		
		return retValue;
	}

}
