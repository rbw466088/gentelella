package framework;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Go implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("开始");
		Object proceed = invocation.proceed();
		System.out.println("结束");
		return proceed;
	}

}
