package com.caggem.thread.Thread;

public class TestThread1 {

	public static void main(String[] args) {
      Thread1 t=new Thread1();
      System.out.println("main started");
      t.start();
      System.out.println("main ended");
      
	}

}
