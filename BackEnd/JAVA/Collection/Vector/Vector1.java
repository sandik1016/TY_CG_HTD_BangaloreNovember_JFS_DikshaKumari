import java.util.Vector;

public class Vector1 {

	public static void main(String[] args) {
		Vector v= new Vector();
		v.add(12);
		v.add(24);
		v.add(56);
		v.add(38);
		v.remove(new Integer(24));
		
		System.out.println(v);
        v.set(1,89);
        
        System.out.println(v);
        
         for(int i=0;i<v.size();i++)
         {
        	 System.out.println(v.get(i));
         }
        	 
        
        
	}

}
