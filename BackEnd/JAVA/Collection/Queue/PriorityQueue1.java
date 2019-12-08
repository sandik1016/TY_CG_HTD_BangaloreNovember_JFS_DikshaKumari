package com.tyss.queue.priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue1 {

	public static void main(String[] args) {
                      Queue q1=new PriorityQueue();
                      q1.offer(76);
                      q1.offer(89);
                      q1.offer(12);
                      q1.offer(45);
                      q1.offer(2);
                      System.out.println(q1);
                      q1.poll();
                      q1.poll();
                      System.out.println(q1);
                      for(Object o1:q1)
                      {
                    	  System.out.println(o1);
                      }
                   q1.remove();
                   System.out.println(q1);
                   
                      
	}

}
