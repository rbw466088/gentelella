package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class UserServiceLogger {
	/**
	 * 前置增强
	 * @param jp
	 */
	public void before(JoinPoint jp) {
		
		System.out.println("前置通知555"+jp.getTarget());

	}
	/**
	 * 方法返回通知增强
	 * @param jp
	 * @param result
	 */
	public void afterReturning(JoinPoint jp,Object result) {
		System.out.println("方法返回通知");
	}
	/**
	 * 异常抛出增强
	 * @param jp
	 * @param e
	 */
	public void afterException(JoinPoint jp,Exception e) {
		System.out.println("出错"+e.getMessage());
		e.printStackTrace();
	}

	/**
	 * 环绕增强
	 * @return
	 */
	public Object around(ProceedingJoinPoint jp) {
		System.out.println("环绕前！！！！！！！");
		if(null!=jp) {
			try {
				Object result = jp.proceed();
				return result;
			} catch (Throwable e) {
				e.printStackTrace();
			}finally {
				System.out.println("环绕后！！！！！！！");
			}
		}
		return jp;
	}
	/**
	 * 后置增强
	 * @param jp
	 * @param result
	 */
	public void after(JoinPoint jp) {
		System.out.println("后置增强");
	}
}
