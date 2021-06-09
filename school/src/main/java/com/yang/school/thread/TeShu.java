package com.yang.school.thread;

public class TeShu extends Thread  {

		@Override
		public void run() {
			for(int i=1;i<11;i++) {
				System.out.println(Thread.currentThread().getName() + "号" + i+"在看病");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
}
