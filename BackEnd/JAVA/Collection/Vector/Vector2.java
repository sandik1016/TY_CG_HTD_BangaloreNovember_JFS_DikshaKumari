import java.util.Vector;

public class Vector2 {

	public static void main(String[] args) {
		Vector v1= new Vector();
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		v1.add(23);
		v1.add(56);
		v1.add(78);
		v1.add(17);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		v1.trimToSize();
		//it will trim the available space of capacity method()
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		v1.setSize(10);
		System.out.println(v1.size());
		System.out.println(v1);
		v1.add(200);
		System.out.println(v1.size());
		System.out.println(v1);
         v1.set(5,600);
		System.out.println(v1);

	}

}
