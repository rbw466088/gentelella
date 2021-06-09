package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import proxy.IDongWu;

public class AopTest {
	public static void main(String[] args) {
		System.out.println("洋洋");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/application.xml");
		IDongWu dongwu = (IDongWu) context.getBean("dog");
		dongwu.ceat();
	}
}
