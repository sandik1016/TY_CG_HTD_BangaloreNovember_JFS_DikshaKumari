
public class Person1 {
	String name;

	public Person1(String name) {
		super();
		this.name = name;
	}
	@Override
	protected void finalize() throws Throwable {//finalize () of object class is overridden here
		// TODO Auto-generated method stub
		super.finalize();
	}
	public static void main(String args[]) throws Throwable {
		
	
	Person p1=new Person("John");
	p1.finalize();
	}
}
