package com.yang.school.thread;

public class Test {
	public static void main(String[] args) {

		Thread t2 = new Thread(new Runner());
		
		Thread t1 = new Thread1(t2);

		t1.start();
		t2.start();
		System.out.println("++++++++++++");
	}
}
