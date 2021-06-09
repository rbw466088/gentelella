package proxy;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;



public class MyAround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("环绕前");
		Object proceed = invocation.proceed();
		System.out.println("环绕后");
		return proceed;
	}






}
