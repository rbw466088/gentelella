package ioc;

import java.text.SimpleDateFormat;
import java.util.Calendar;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		System.out.println(context);
		People p1 = (People)context.getBean("p1");
		System.out.println(p1);
		p1.say();
		
		People p2 = context.getBean("p2",People.class);
		System.out.println(p2);
		p2.say();
		//Calendar c1 =  Calendar.getInstance();
		Calendar bean = (Calendar)context.getBean("c1");
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(bean.getTime()));
		
	}
	
	
	
}
