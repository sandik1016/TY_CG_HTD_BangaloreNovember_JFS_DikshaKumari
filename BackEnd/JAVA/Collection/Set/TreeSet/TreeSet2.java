import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet2 {

	public static void main(String[] args) {
		TreeSet<Studenr> t1= new TreeSet<Studenr>();
		t1.add(new Studenr(22,"divu"));
		t1.add(new Studenr(24,"palu"));
		t1.add(new Studenr(22,"divu"));
		 Iterator<Studenr> itr=t1.iterator();
		 while(itr.hasNext())
		 {
			 System.out.println(itr.next());
		 }
		

	}

}
