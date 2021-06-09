package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import ioc.Isay;

public class MyInvocationHandler implements InvocationHandler{
	
	//创建一个接口父类的属性
	private Isay targets;
	
	private List<IBefores>  befores;
	
	public List<IBefores> getBefores() {
		return befores;
	}
	public void setBefores(List<IBefores> befores) {
		this.befores = befores;
	}
	public Isay getTargets() {
		return targets;
	}
	/**
	 * set方法，用于给接口父类属性赋值（值：实现接口父类的子类名称）
	 * @param target
	 */
	public void setTargets(Isay targets) {
		this.targets = targets;
	}
	

	/**
	 * 实现InvocationHandler接口， 自动重写的invoke方法（动态代理）
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("准备动态执行"+method.getName()+"方法");
		long beginTime = System.currentTimeMillis();	//当前毫秒数
		Object result =null;
		try{
//			 if(null!=befores) {
//				 for (IBefores bef : befores) {
//					bef.before();
//				}
//			 }
			 result = method.invoke(targets, args);
			 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		long endTime = System.currentTimeMillis();		//当前毫秒数
		System.out.println("执行完毕,时间:"+(endTime-beginTime));	//获取毫秒数差
		//System.out.println(result);
		return result;
	}
}	
