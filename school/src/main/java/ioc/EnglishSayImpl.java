package ioc;

public class EnglishSayImpl implements Isay {

	public void say() {
		System.out.println("hello");
	}

	public void test(String str) {
		System.out.println(str);		
	}

}
