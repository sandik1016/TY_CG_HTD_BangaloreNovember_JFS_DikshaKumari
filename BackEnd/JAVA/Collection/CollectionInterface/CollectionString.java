import java.util.ArrayList;
import java.util.Collection;

public class CollectionString {

	public static void main(String[] args) {
		Collection c1= new ArrayList();
		c1.add("John");
		System.out.println(c1);
		c1.remove("John");
		System.out.println(c1);
		
		System.out.println(c1.size());
		
		System.out.println(c1.isEmpty());
		c1.add("anu");
		
		System.out.println(c1.contains(12));

	}

}
