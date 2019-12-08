import java.util.List;
import java.util.ArrayList;

public class List1 {

	public static void main(String[] args) {
		
			      List l1 = new ArrayList();
				//methods present in the list interface
				l1.add(0,12);
				l1.add(1,12);
				
				l1.add(2,126);
				l1.add(3,102);
				l1.add(1,112);
				System.out.println(l1);
								l1.remove(1);
				System.out.println(l1);
				System.out.println(l1.indexOf(102));
				l1.add(110);
				System.out.println("----------------");
				for(int i=0;i<l1.size();i++)
					System.out.println(l1.get(i));
				List l2 = new ArrayList();
				
				l2.add(33);
				l2.add(58);
				l2.add(96);
				
				System.out.println(l1.addAll(l2));
				System.out.println(l1);
				
                List l3 = new ArrayList();
				
				l3.add(45);
				l3.add(55);
				l3.add(66);
				l3.set(1,10001);
				System.out.println(l3);
			      
				 List l5 = new ArrayList();
				l2.add(45);
				l2.add(55);
			    l2.add(66);
				List l6=l5.subList(0,6);
			    System.out.println(l6);
				
				
			}

		


	}


