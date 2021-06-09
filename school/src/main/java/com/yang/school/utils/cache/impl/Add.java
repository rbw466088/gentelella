package com.yang.school.utils.cache.impl;

public class Add {
	
//	private static volatile Add instance;
	
	private Add() {
	}
	
	//双检查方式
//	public static synchronized Add getInstance() {
//		if(null==instance) {
//			synchronized (Add.class) {
//				if(null==instance) {
//					instance = new Add();
//				}
//			}
//		}
//		return instance;
//	}
	
	//静态内部类方式
	private static class AddShow{
		public static final Add instance = new Add();
	}
	
	public static final Add getInstance() {
		return AddShow.instance;
	}
	
	
}
