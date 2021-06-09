package com.yang.school.thread;

public class SleepRunner implements Runnable {

	@Override
	public void run() {
		System.out.println("开始执行");
		try {
			System.out.println("准备睡觉");
			Thread.sleep(3000);
			System.out.println("睡到自然醒");
		} catch (InterruptedException e) {
//			e.printStackTrace();
			System.out.println("手机 响了");
		}
		System.out.println("起床了，懒猪");
	}

}
