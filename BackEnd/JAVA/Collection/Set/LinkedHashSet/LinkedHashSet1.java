
import java.util.LinkedHashSet;

public class LinkedHashSet1 {

	public static void main(String[] args) {
		LinkedHashSet h1=new LinkedHashSet();

		h1.add(22);
		h1.add(24);
		h1.add(24);
		h1.add(23);
		h1.add(21);
		h1.add(null);
		
		System.out.println();

		for(Object s1:h1) {
			System.out.println(s1);
		}


	}
	}


