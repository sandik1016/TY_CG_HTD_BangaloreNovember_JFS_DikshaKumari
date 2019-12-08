
public class TestAnimal {

	public static void main(String[] args) {
Dog d1=new Dog("pinko");
System.out.println(d1.name);
Animal a1=new Dog("jimmi");
System.out.println(a1.name);
	}

}
//it is an example why we create constructor in abstract class .as we know that abstract doesn't create a class and constructor is used to initialise an object.in case if abstract class contain concrete method or non static variable where it is needed to initialize it so we have to create another class and then we pass value through parameter to initialize it.Here also upcasting is applicable.