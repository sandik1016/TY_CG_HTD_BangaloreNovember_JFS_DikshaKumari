package com.caggem.thread.Thread;

public class TestUsr {

	public static void main(String[] args) {
		System.out.println("main started");
		PVR p=new PVR();
		User u1=new User(p);
		u1.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.leaveMe();
		System.out.println("main ended");
		
		
		

	}

}
