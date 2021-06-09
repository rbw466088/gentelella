package aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;

import proxy.IDongWu;

public class AopImpl implements InvocationHandler {

	private IDongWu dongwu;
	
	public IDongWu getDongwu() {
		return dongwu;
	}



	public void setDongwu(IDongWu dongwu) {
		this.dongwu = dongwu;
	}



	@Override
	public Object invoke(Object arg0, Method method, Object[] args) throws Throwable {
		Object invoke = method.invoke(dongwu, args);
		return invoke;
	}

}
