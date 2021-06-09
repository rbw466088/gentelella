package com.yang.school.thread;

public class Hao {

	public static void main(String[] args) {
		Thread t1 = new Thread(new TeShu(),"特殊");
		Thread t2 = new Thread(new PuTong(t1), "普通");
		t1.start();
		t2.start();
	}
}
