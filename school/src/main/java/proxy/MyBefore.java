package proxy;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;

public class MyBefore implements MethodBeforeAdvice {
	
	ProxyFactoryBean p ;
	{
//		p.setTarget(target);					  //注入目标对象
//		p.setProxyInterfaces(proxyInterfaces);    //注入代理接口定义
//		p.setInterceptorNames(interceptorNames);  //注入增强
	}
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("前置增强");
	}

}
