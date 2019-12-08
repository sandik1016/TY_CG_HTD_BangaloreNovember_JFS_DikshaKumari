import java.util.LinkedList;

public class LinkedList3 {

	public static void main(String[] args) {
		LinkedList l1= new LinkedList();
		l1.add(12);
		l1.add(24);
		l1.add(56);
		l1.add(null);
		l1.add(24);
		l1.add(56);
		
		System.out.println("---------------------peek and peekfirst and peeklast-----------");
		System.out.println(l1.peek());
		System.out.println(l1.peekFirst());//it is like get()
		System.out.println(l1.peekLast());
		System.out.println(l1);
		
		System.out.println("----poll and pollfirst and polllast--------");
		System.out.println(l1.poll());
		System.out.println(l1);//it remove element and return that element which has been removed
		System.out.println(l1.pollFirst());
		System.out.println(l1);//poll is same as pollfirst and peek is same as peekfirst
		System.out.println(l1.pollLast());
		System.out.println(l1);
		
		
		LinkedList l2= new LinkedList();
		l2.add(12);
		l2.add(4);
		l2.add(6);
		l2.add(null);
		
		System.out.println("-------offer and offerfirst and offerlas------------");
		
		System.out.println(l1.offer(67));
		System.out.println(l1);//offer is asme as offerlast
		System.out.println(l1.offerFirst(89));
		System.out.println(l1);
		System.out.println(l1.offerLast(78));
		System.out.println(l1);
		
	}

}
 