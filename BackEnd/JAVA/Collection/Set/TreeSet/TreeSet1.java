import java.util.TreeSet;

public class TreeSet1 {
	public static void main(String[] args) {
		TreeSet t1= new TreeSet();
		t1.add(22);
		t1.add(24);
		t1.add(21);
		t1.add(23);
		t1.add(21);
		//t1.add(null);
		//t1.remove(21);
		for(Object o1:t1) {
			System.out.println(o1);
		}
				
	}
}
