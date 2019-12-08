import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedList2 {
	public static void main(String[] args) {
		LinkedList l1= new LinkedList();
		
		l1.add(12);
		l1.add(24);
		l1.add(56);
		l1.add(null);
		l1.add(24);
		l1.add(56);
		//addFirst
		l1.addFirst(78);
		System.out.println(l1);
		//addLast
		l1.addLast(85);
		System.out.println(l1);
		//getFirst
		
		System.out.println(l1.getFirst());
		//getLast
		
		System.out.println(l1.getLast());
		//remove
		l1.remove();
		System.out.println(l1);
		//removeFirst
		l1.removeFirst();
		System.out.println(l1);
		//removeLast
		l1.removeLast();
		System.out.println(l1);
		//removeFirstOccurrence
		l1.removeFirstOccurrence(24);
		System.out.println(l1);
		//removeLastOccurrence
		l1.removeLastOccurrence(56);
		System.out.println(l1);
		
		
	}
	
}
