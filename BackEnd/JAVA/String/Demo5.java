
public class Demo5 {

	public static void main(String[] args) {
		Demo4 d1 = new Demo4("John",25);
		System.out.println(d1.hashCode());
		d1= new Demo4("Mikel",25);
		System.out.println(d1.hashCode());
	int age=d1.getAge();
	String name=d1.getName();
	System.out.println("age is "+age);
	System.out.println("name is "+name);
		

	}

}
