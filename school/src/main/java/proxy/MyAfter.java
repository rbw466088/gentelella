package proxy;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfter implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("后置增强");
	}

}
