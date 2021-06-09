package com.yang.school.thread;

public class PuTong implements Runnable {
	
	private Integer i = 1;
	private Integer ticketCount = 60;
	
	private Thread te;  
	
	public Thread getTe() {
		return te;
	}

	public void setTe(Thread te) {
		this.te = te;
	}
	public PuTong(Thread te) {
		this.te = te;
	}
	@Override
	public void run() {
		while(true){
			synchronized (Hao.class) {
				if(ticketCount>i) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "号" + i+"在看病");
					i++;
				}else{
					break;
				}
			}
		}

	}

}
