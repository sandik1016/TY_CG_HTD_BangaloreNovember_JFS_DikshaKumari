package com.caggem.thread.Thread;

public class TestIRCTC {

	public static void main(String[] args) {
		System.out.println("main started");
		IRCTC p=new IRCTC();
		User1 u1=new User1(p);
		u1.start();
		User1 u2=new User1(p);
		u2.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.leaveMe();
	
		System.out.println("main ended");
	}

}
