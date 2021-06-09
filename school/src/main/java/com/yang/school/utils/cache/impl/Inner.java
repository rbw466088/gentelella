package com.yang.school.utils.cache.impl;

//内部类
public class Inner {
	public class InnerOne{
		public InnerOne(){
			System.out.println("create InnerOne");
		}
	}
//	public static void main(String[] args) {
//		Inner inner = new Inner();
//		InnerOne innerOne = inner.new InnerOne();
//	}
	
	
	//成员内部类
/*	public class One{
		public One(){
			System.out.println("create one");
		}
	}
	protected class Two{
		public Two(){
			System.out.println("create Two");
		}
	}
	class Three{
		public Three(){
			System.out.println("create Three");
		}
	}
	
	private class Four{
		public Four(){
			System.out.println("create Four");
		}
	}
	
	public final class Five{
		public Five(){
			System.out.println("create Five");
		}
	}*/
	
//	public One getOne(){
//		return this.new One();
//	}
	
//	public static void main(String[] args) {
//		Inner inner = new Inner();
//		Five five = inner.new Five();
//	}

	//局部内部类，只能使用abstract，final修饰符进行修饰
/*	public void say(){
		class One{
			public One(){
				System.out.println("Part One");
			}
		}
		new One();
	}
	
	public static void main(String[] args) {
		new Inner().say();
	}*/

		//接口式的匿名内部类
		IA a= new IA(){
			@Override
			public void say() {
				System.out.println("IA say");
			}
		};
		//继承式匿名内部类
		Base b = new Base() {
			@Override
			void say() {
				//参数式匿名内部类
				this.defaultSay(new IA(){
					@Override
					public void say() {
						System.out.println("参数IA say");	
					}			
				});
			}
		};
		
		public static void main(String[] args) {
			Inner out = new Inner();
			out.a.say();
			out.b.say();
		}
	}
//	interface A{
//		void say();
//	}
	abstract class Base{
		abstract void say();
		void defaultSay(IA a){
			System.out.println("Base defaultSay:"+a.toString());
		}
	}
	
	
