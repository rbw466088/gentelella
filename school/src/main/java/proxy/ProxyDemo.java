package proxy;


import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import ioc.ChinaSayImpl;
import ioc.Isay;

public class ProxyDemo {
	public static void main(String[] args) {
		//创建动态代理类的对象
		MyInvocationHandler handler = new MyInvocationHandler();
		//为动态代理类内的接口属性赋值（值：实现接口父类的子类名称）
		handler.setTargets(new ChinaSayImpl());
		//创建获取动态代理相关接口的实例
		Isay say = (Isay)Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[] {Isay.class}, handler);
		//System.out.println(say.getClass());
		List<IBefores>  befores = new ArrayList<IBefores>();
		befores.add(new BeforesOne());
		befores.add(new BeforesTwo());
		handler.setBefores(befores);
		say.say();
		say.test("卢诗新");
	}
}
