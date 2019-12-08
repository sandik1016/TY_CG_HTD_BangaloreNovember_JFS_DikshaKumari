import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList1 {

	public static void main(String[] args) {
		ArrayList<Integer> a1= new ArrayList<Integer>();
		a1.add(1);
		a1.add(29);
		a1.add(89);
		System.out.println(a1);
		a1.remove(1);
		System.out.println(a1);
		System.out.println("_________________for loop _____________");
		//iterating an arraylist using for loop
		for(int i=0;i<a1.size();i++)
		{
			System.out.println(a1.get(i));
			
		}
		
		System.out.println("_________________foreach loop _____________");
		//iterating an arraylist using for loop
		for(Integer i:a1)
		{
			System.out.println(i);
			
		}
		System.out.println("_________________iterator method _____________");
		Iterator<Integer> itr = a1.iterator();
		
		while(itr.hasNext()) {

			System.out.println(itr.next());
		}
		System.out.println("_________________listiterator method _____________");
		ListIterator<Integer> itr1 = a1.listIterator(a1.size());
		
		while(itr1.hasPrevious()) {

			System.out.println(itr1.previous());


			
			
			
			
			
			
			
			
			
			
			
			
			System.out.println("_________________iterator method here no need of size() _____________");
			Iterator<Integer> itr2 = a1.iterator();
			
			while(itr2.hasNext()) {

				System.out.println(itr2.next());
			}
			
			ListIterator<Integer> itr3 = a1.listIterator();
			
			while(itr3.hasPrevious()) {

				System.out.println(itr3.previous());
		}	
			
			
			
			ArrayList<Integer> a2= new ArrayList<Integer>();
			a2.add(23);
			a2.add(24);
			System.out.println(a2);
			a2.remove(new Integer(23));//removing element in terms of object
			System.out.println(a2);
		
	}

}
}
