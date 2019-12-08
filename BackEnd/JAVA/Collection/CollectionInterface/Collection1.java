import java.util.ArrayList;
import java.util.Collection;

public class Collection1 {

	public static void main(String[] args) {
		Collection c1= new ArrayList();
		
		//adding element inside the collection
		c1.add(12);//converting primitive int to non primitive integer as collection only takes object type it is done with the help of autoboxing
		System.out.println(c1);
		//removing the element from the collection
		c1.remove(12);
		System.out.println(c1);
		//finding the size of the collection
		System.out.println(c1.size());
		//checking than collection is empty or not
		System.out.println(c1.isEmpty());
		c1.add(12);
		//checking whether 12 object is there or not inside collection
		System.out.println(c1.contains(12));

	}

}
