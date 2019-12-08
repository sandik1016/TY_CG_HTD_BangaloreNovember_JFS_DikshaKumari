package com.caggem.thread.Thread;

public class PVR {
 synchronized void confirmTicket() {
	  for(int i=0;i<5;i++) {
		  System.out.println(i);
	  
//		  try {
//			  Thread.sleep(500);
//			  }
//	  catch(InterruptedException e) {
//		  System.out.println(e.getMessage());
//		  }
//  
  try {
	wait();
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
	  
  }
	  
}synchronized void leaveMe() {//wait and notify is in object class it must be written in synchronized ()
	  System.out.println("notify called");
	  notify();
}
}