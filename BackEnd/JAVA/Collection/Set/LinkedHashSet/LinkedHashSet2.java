import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSet2 {

	public static void main(String[] args) {
		LinkedHashSet<Integer> h1=new LinkedHashSet<Integer>();

		h1.add(22);
		h1.add(24);
		h1.add(24);
		h1.add(23);
		h1.add(21);
		h1.add(null);


		Iterator<Integer> iterator=h1.iterator();

		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}


	}

}
