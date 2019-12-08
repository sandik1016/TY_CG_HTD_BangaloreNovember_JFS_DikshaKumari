import java.util.LinkedList;

public class LinkedList4 {
  public static void main(String args[]) {
	  LinkedList l1= new LinkedList();
		l1.add(12);
		l1.add(24);
		l1.add(56);
		l1.push(56);//add to zeroth
		System.out.println(l1);
		l1.pop();//remove element from zeroth
		System.out.println(l1);
		
		System.out.println(l1.element());//element()
		System.out.println(l1);//get from zeroth
		
		
		
  }
}
