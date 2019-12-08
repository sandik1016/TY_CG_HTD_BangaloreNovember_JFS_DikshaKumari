
public class TestPerson {
  public static void main(String args[]) throws Throwable {
	  System.out.println("============main started--------");
	  Person p=new Person("John");
	  p.finalize();//throws exception nd it also not eligible for garbage collector
	  p=null;
	  System.gc();//calling garbage collector
	  System.out.println("============main endded--------"); 
  }
  
}
