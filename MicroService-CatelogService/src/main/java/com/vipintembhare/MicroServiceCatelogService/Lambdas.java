package com.vipintembhare.MicroServiceCatelogService;

/*Lambdas
 * 
 * Why Lambdas?
 * 1. Enables functional prog.
 * 2. Readable and concise code
 * 
 * Why we need functional prog?
 * Problems with OOP
 * 
 * 
 * lamdba expressions are function which don't belong to class
 * function as value.
 * 
 * 
 * 
 * Type Inference
 * 
 * 
 * 
 * 
 * */
public class Lambdas {

	
	public static void main(String[] args) {
	Greeter ablockOfCode = () ->{
		System.out.print("Hello World");
	};
	
	Greeter greetingFunction= () ->System.out.println("Hello World");
	
	Operation doubleNumber =(int a)->{
		return a*2;
	};
	
	Operation doubleNumber2 = (int a)->a*2;
	
	SafeDivide safeDivideFunction=(int a,int b) ->{
		if(b==0) return 0;
		return a/b;
	};
	ablockOfCode.perform();
	greetingFunction.perform();
	System.out.println(doubleNumber.doubleNumber(5));
	System.out.println(doubleNumber2.doubleNumber(5));
	System.out.println(safeDivideFunction.safeDivide(4, 3));
	
	Runnable run1 = ()->{
		for (int i=0;i<10;i++) 
			System.out.println(i);
		};
	Thread thread1 = new Thread(run1);
	Thread thread2 = new Thread(run1);
	thread1.start();
	thread2.start();
	}
	
	interface Greeter{
		void perform();
	}
	
	interface Operation{
		int doubleNumber( int a);
	}
	
	interface SafeDivide{
		double safeDivide(int a,int b);
	}
}
