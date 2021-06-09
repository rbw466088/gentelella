package ioc;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class People {
	
	private Isay say;
	private String name;

	/**
	 * 用list集合类型注入
	 * @param values
	 */
	public void setList(List<String> list) {
		if(null!=list) {
			for (String string : list) {
				System.out.println(string);
			}
		}
	}
	/**
	 * 用map集合类型注入
	 * @param map
	 */
	public void setMap(Map<String,String> map) {
		if(null!=map) {
			Set<String> set = map.keySet();
			for (String string : set) {
				System.out.println(map.get(string));
			}
		}
	}
	/**
	 * 用set集合类型注入
	 * @param set
	 */
	public void setSet(Set<String> set) {
		if(null!=set) {
			for (String string : set) {
				System.out.println(string);
			}
		}
	}
	
	public void setName(String name) {
		this.name=name;
		System.out.println("用户："+this.name);
	}

	public Isay getSay() {
		return say;
	}

	public void setSay(Isay say) {
		this.say = say;
	}

	public void say() {
		say.say();
	}
	
	public People() {
		System.out.println("~~~~~~~~~~~~~");
	}
	
	public People(String name,int age) {
		System.out.println("~~~~~~~~~~~~~"+name+"~~"+age);
	}
	
	
	
	
}
