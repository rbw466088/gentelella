package framework;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class ShuiJiao implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("小狗在睡觉");
	}
	
}
