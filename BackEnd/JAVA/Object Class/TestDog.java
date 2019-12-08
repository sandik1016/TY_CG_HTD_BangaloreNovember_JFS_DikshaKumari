
public class TestDog {

	public static void main(String args[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Dog d1=new Dog("pINKY");
        Class c1=d1.getClass();//Object method getClass//c1 is holding class dog type 
		System.out.println(c1);
		Dog d2=(Dog)c1.newInstance();//newInstance way to create object//downcasting
		System.out.println(d2.name);
		//forName()
		Class c2=Class.forName("Dog");
		System.out.println(c2);
		Dog d3=(Dog)c2.newInstance();
		System.out.println(d3.name);
		
		
		
		Dog d4=new Dog("cINKY");
		
        Class c3=d4.getClass();
		System.out.println(c3);
		
	}

}

