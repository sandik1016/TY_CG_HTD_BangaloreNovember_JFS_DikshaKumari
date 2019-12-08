
public class Employee implements Comparable<Employee>{
	int age;
    String name;
    double salary;
	public Employee(int age, String name,double salary) {
		super();
		this.age = age;
		this.name = name;
		this.salary = salary;
		
	}
//	@Override
//	public int compareTo(Employee o) {
//		if(this.age>o.age)
//		return 1;
//		else if (this.age<o.age)
//			return -1;
//		return 0;
	//}
	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.name);//ascending order
		//return o.name.compareTo(this.name);//descending order
	}


}
