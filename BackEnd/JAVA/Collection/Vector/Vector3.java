import java.util.Vector;

public class Vector3 {
	public static void main(String[] args) {
		Vector v1= new Vector();
		v1.addElement(23);
		v1.addElement(56);
		v1.addElement(78);
		v1.addElement(17);
		System.out.println(v1);
		v1.removeElement(new Integer(78));
		
			System.out.println(v1);
			v1.removeElementAt(2);
			System.out.println(v1);
			Object i1[]=new Object[v1.size()];
			v1.copyInto(i1);
			for(int i=0;i<i1.length;i++) {
				System.out.println(i1[i]);
			}
			v1.removeAllElements();//same like clear() 
			System.out.println(v1);
			
			
			
			Vector v2= new Vector();
			v2.addElement(23);
			v2.addElement(56);
			v2.addElement(78);
			v2.addElement(17);
			System.out.println(v2);
			
			System.out.println(v2.size());
			System.out.println(v2.capacity());
			v2.trimToSize();
			System.out.println(v2.size());
			System.out.println(v2.capacity());
			v2.ensureCapacity(6);//it will be double 
			v2.setSize(8);
			System.out.println(v2.size());//8
			System.out.println(v2.capacity());//12 as double the capacity of 6 in vector
			System.out.println(v2);
			
}
}