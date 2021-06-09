package com.yang.school.thread;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("主线程开始执行");
		Thread t1 = new Thread(new SleepRunner());
		t1.start();

		try {
			Thread.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		t1.interrupt();
		System.out.println("主线程执行完毕");
	}
}
