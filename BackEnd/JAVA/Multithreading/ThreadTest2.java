package com.caggem.thread.Thread;

public class ThreadTest2 {

	public static void main(String[] args) {
		System.out.println("main started");
		Thread2 t2 =new Thread2();
		Thread t=new Thread(t2);
		t.run();
		System.out.println("thread ended");

	}

}
