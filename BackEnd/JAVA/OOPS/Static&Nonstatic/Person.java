package staticAndNonstatic;

public class Person {
    static int age;
    String name;
    
    void personDetails()
    {
    	System.out.println("Name of a person is "+name+" and age is "+age);
    	staticPersonDetails();
    }
    void staticPersonDetails()
    {
    	System.out.println(age);
    }
}
