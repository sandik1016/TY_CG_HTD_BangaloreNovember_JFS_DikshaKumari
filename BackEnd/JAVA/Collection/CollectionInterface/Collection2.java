import java.util.ArrayList;
import java.util.Collection;

public class Collection2 {

	public static void main(String[] args) {
       Collection c = new ArrayList();
       c.add(12);
       c.add(24);
       c.add(45);
       c.add(67);
       Collection c1 = new ArrayList();
       c1.add(12);
       c1.add(24);
       c1.add(45);
       c1.add(67);
       c1.addAll(c);
       System.out.println(c1);
       
       Collection c4 = new ArrayList();
       c4.add(29);
       c4.add(23);
       c4.add(16);
       c4.add(19);
       Collection c5 = new ArrayList();
       c5.add(25);
       c5.add(23);
       c5.add(12);
       c5.add(13);
       System.out.println(c4);
       c4.retainAll(c5);//it will check the common element in both list,it will remove the uncommon element from c5
       System.out.println(c4);
       System.out.println(c4.containsAll(c5));
       
       c4.clear();
       System.out.println(c4);
       
       
       Collection c6 = new ArrayList();
       c6.add(12);
       c6.add(23);
       
       Object a[]=c6.toArray();//collection cnvrtd to array
       
       for(int i=0;i<a.length;i++) {
           System.out.println(a[i]);
           
           
           //we can write for loop to iterate elements in arraylist .iterate usng for loop .but we cannot retrieve a particular element from a list in a collection


       }
       
       
	}

}
