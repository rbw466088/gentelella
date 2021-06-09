package test;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.YANG.BDQN_shop.entity.feng.Category;
import com.YANG.BDQN_shop.exception.ServiceException;
import com.YANG.BDQN_shop.service.feng.ICategory;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
		
		ICategory category =context.getBean("categoryService",ICategory.class);
		List<Category> categoryList=null;
		try {
			categoryList = category.findAll();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		System.out.println(categoryList.size());
	}
}
