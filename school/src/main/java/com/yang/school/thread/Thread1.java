package com.yang.school.thread;

public class Thread1 extends Thread {

	private Thread t2;
	
	public Thread getT2() {
		return t2;
	}

	public void setT2(Thread t2) {
		this.t2 = t2;
	}

	public Thread1(Thread t2) {
		this.t2 = t2;
	}

	@Override
	public void run() {
		
		if(null!=t2) {
			try {
				System.out.println("开始t2");
				t2.join();
				System.out.println("结束t2");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//		System.out.println("进去");
//		Thread.yield();
//		System.out.println("出来");
	
	}
}
