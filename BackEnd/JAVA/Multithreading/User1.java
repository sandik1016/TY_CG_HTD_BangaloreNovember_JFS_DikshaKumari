package com.caggem.thread.Thread;

public class User1 extends Thread{
	IRCTC p;
	User1(IRCTC p){
		this.p=p;
		
	}

	public void run() {
		p.confirmTicket();
	}
}


