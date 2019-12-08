package com.tyss.queue.priorityQueue;

import java.util.PriorityQueue;

public class PriorityQue {

	public static void main(String[] args) {
		PriorityQueue<Student> p1=new PriorityQueue<Student>();
		p1.offer(new Student("divya",22));
		p1.offer(new Student("shree",23));
		p1.offer(new Student("divya",22));
		for(Object obj:p1) {
			System.out.println(obj);
		}
		

	}

}
