package com.tyss.access.pack2;
import com.tyss.access.pack1.Student;

public class TestStudent extends Student {
	
	protected TestStudent(String name)
	{
		//implicit super constructor is undefined.must explicitly invoke another constructor
	    super(name);
	}
   void studentDetails() {
	  System.out.println("name is"+studName) ;
   }
	public static void main(String[] args) {
  TestStudent s1=new TestStudent("chinnu");
  TestStudent s2=new TestStudent("chinna");
  s2.studDetails();
  s1.studentDetails();
	}
 
}
