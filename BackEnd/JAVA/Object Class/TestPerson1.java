
public class TestPerson1  extends Person1{
	
	public TestPerson1(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) throws Throwable {
		 System.out.println("============main started--------");
		  Person p=new Person("John");
		  TestPerson1 p2=new TestPerson1("Johnny");
		  p.finalize();
		  p2.finalize();//throws exception nd it also not eligible for garbage collector
		  p=null;
		  System.gc();//calling garbage collector
		  System.out.println("============main endded--------"); 
	}
}
