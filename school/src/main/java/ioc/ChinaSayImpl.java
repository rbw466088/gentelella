package ioc;



public class ChinaSayImpl implements Isay {

	public void say() {
		System.out.println("你好 ");

	}
	@Override
	public void test(String str) {
		System.out.println(str);

	}
	

	
}
