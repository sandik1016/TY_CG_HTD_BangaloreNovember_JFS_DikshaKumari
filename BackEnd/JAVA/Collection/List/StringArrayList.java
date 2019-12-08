 import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class StringArrayList {

	public static void main(String[] args) {
		ArrayList<String> a1= new ArrayList<String>();
		a1.add("John");
		a1.add("Anu");
		a1.add("divya");
		a1.add("visu");
		a1.add("kartik");
		System.out.println(a1);
		System.out.println(a1.size());
		System.out.println(a1.isEmpty());
		a1.remove("visu");
		System.out.println(a1);
		a1.add("abhi");
		System.out.println(a1.contains("abhi"));
		//addall
		ArrayList<String> a2= new ArrayList<String>();
	        
	      
	       a2.add("abhi");
	       a2.add("kartik");
	       a2.add("bazigar");
	       a2.add("shukla");
	       a2.addAll(a1);
	       System.out.println(a2);
	       //removeall
	       a2.removeAll(a1);
	       System.out.println(a2);
	       //containsall
	       System.out.println(a2.containsAll(a1)); 
	       
	       //retainall
	       a2.retainAll(a1);
	       System.out.println(a2);
	       //a2.clear
	       a2.clear();
	       System.out.println(a2);
	       //<----------------list-------------->
	       ArrayList<String> a3= new ArrayList<String>();
			a3.add(0,"Johnny");
			a3.add(1,"Anuma");
			a3.add(2,"divyanka");
			a3.add(3,"visuha");
			a3.add(4,"kartike"); 
			
			
			a3.remove(3);
			System.out.println(a3);
			
			a3.indexOf("kartike");
			System.out.println(a3);
			a3.lastIndexOf("kartike");
			System.out.println(a3);
			ArrayList<String> a4= new ArrayList<String>();
			a4.add(0,"John");
			a4.add(1,"Anu");
			a4.add(2,"divya");
			a4.add(3,"visu");
			a4.add(4,"kartik");
			
			a3.addAll(1, a4);
			
			System.out.println(a3);
			
			a3.set(3, "goura");
			System.out.println(a3);
			a3.subList(2, 5);
			System.out.println(a3);
		
			
			
			
			
			
			
			
			
			
			
			
			System.out.println("_________________for loop _____________");
			//iterating an arraylist using for loop
			for(int i=0;i<a3.size();i++)
			{
				System.out.println(a3.get(i));
				
			}
			
			System.out.println("_________________foreach loop _____________");
			//iterating an arraylist using for loop
			for(String i:a3)
			{
				System.out.println(i);
				
			}
			System.out.println("_________________iterator method _____________");
			Iterator<String> itr = a3.iterator();
			
			while(itr.hasNext()) {

				System.out.println(itr.next());
			}
			System.out.println("_________________listiterator method _____________");
			ListIterator<String> itr1 = a3.listIterator(a3.size());
			
			while(itr1.hasPrevious()) {

				System.out.println(itr1.previous());


				
				
				
				
			
			
			}       
	       
	}

}
