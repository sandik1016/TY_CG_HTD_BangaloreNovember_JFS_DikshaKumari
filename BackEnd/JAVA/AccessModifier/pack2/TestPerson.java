package com.tyss.access.pack2;
import com.tyss.access.pack1.Person;//access all type of members
import static com.tyss.access.pack1.Person.*;//access all static members without using classname
public class TestPerson {

	public static void main(String[] args) {
System.out.println("age is "+age);
Person p1=new Person("Chinnu");
p1.personDetails();
details();
	}

}
