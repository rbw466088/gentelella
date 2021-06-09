package com.yang.school.thread;

public class TicketThread {
	Integer ticketCount = 10;
	public static void main(String[] args) {
		TicketThread t = new TicketThread();
		Sell s1 = t.new Sell("s1",2000);
		Sell s2 = t.new Sell("s2",2000);
		s1.start();
		s2.start();
	}
	class Sell extends Thread{
		private String name;
		private int sleepTime;
		public Sell(String name,int sleepTime){
		this.name = name;
		this.sleepTime = sleepTime;
		}
		
		public void run() {
			while(true){
				System.out.println("。。。。。。。。。。。");
				synchronized (TicketThread.class) {
					if(ticketCount>0){
						try {
							Thread.sleep(sleepTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(this.name+":售出票"+ticketCount--);
					}else {
						break;
					}
					System.out.println("释放资源！");
				}
			}
		}
	}
	
	

}
