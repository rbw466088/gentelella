package com.yang.school.utils.cache.impl;

public class Test {
	private TestListener listener;
	private void click(){
		Event event = new Event();
		event.setEventName("单击");
		event.setEventObject(this);
		listener.doSomething(event);
	}
	public void addTestListener(TestListener test){
		this.listener = test;
	}
	public static void main(String[] args) {
		//模拟单击事件
		Test t = new Test();
		t.addTestListener(new TestListener() {
			@Override
			public void doSomething(Event event) {
				System.out.println("单击执行");
			}
		});
		t.click();
	}

}
