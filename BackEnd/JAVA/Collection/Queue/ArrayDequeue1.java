package com.tyss.queue.priorityQueue;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeue1 {

	public static void main(String[] args) {
		ArrayDeque a1 = new ArrayDeque();
		a1.add(23);
		a1.add(2);//preserves the order
		a1.addFirst(45);
		a1.add(15);
		a1.add(78);
		a1.add(4);
		Iterator itr = a1.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
     a1.addLast(23);
     a1.getFirst();
     System.out.println(a1);
     a1.getLast();
     System.out.println(a1);
     a1.remove();
     System.out.println(a1);
     a1.removeFirst();
     System.out.println(a1);
     a1.removeLast();
     System.out.println(a1);
     a1.removeFirstOccurrence(23);
     System.out.println(a1);
     a1.removeLastOccurrence(78);
     System.out.println(a1);
     a1.peek();
     System.out.println(a1);
     a1.peekFirst();
     System.out.println(a1);
     a1.peekLast();
     System.out.println(a1);
     a1.poll();
     System.out.println(a1);     a1.pollFirst();
     System.out.println(a1);
     a1.pollLast();
     System.out.println(a1);
     a1.offer(45);
     System.out.println(a1);
     a1.offerLast(66);
     System.out.println(a1);
     a1.offerFirst(56);
     System.out.println(a1);
     a1.push(48);
     System.out.println(a1);
     a1.pop();
     System.out.println(a1);
     a1.element();
     System.out.println(a1);
     
	}

}
