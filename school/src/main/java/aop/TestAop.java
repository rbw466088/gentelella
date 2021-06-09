package aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ioc.Isay;



public class TestAop {
	public static void main(String[] args) {
		//创建动态代理类的对象
		//MyInvocationHandler handler = new MyInvocationHandler();
		//为动态代理类内的接口属性赋值（值：实现接口父类的子类名称）
		//handler.setTarget(new ChinaSayImpl());
		
		//创建获取动态代理相关接口的实例
		//Isay say = (Isay)Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[] {Isay.class}, handler);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		Isay say = (Isay) context.getBean("chinaProxy");
		say.say();
//		Isay says = (Isay) context.getBean("englishImpl");
//		says.say();
	}
}
