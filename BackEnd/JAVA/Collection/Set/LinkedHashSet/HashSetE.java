import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HashSetE {

	public static void main(String[] args) {
		LinkedHashSet<Employee>h1=new LinkedHashSet<Employee>();

		h1.add(new Employee(22,"Divya"));
		h1.add(new Employee(24,"anu"));
		h1.add(new Employee(21,"Kivya"));
		h1.add(new Employee(23,"vidya"));
		h1.add(new Employee(21,"Kivya"));

		Iterator<Employee> iterator = h1.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());

	}

	}

}
