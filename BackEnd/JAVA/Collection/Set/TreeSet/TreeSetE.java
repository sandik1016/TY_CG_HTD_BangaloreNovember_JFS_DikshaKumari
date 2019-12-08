import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetE {

	public static void main(String[] args) {
		
		EmployeeName e1 =new EmployeeName();
		EmployeeAge e2 =new EmployeeAge();
		EmployeeSalary e3 =new EmployeeSalary();
		
		TreeSet<Employee> t1= new TreeSet<Employee>(e2);
		t1.add(new Employee(22,"divu",34000));
		t1.add(new Employee(24,"palu",24000));
		t1.add(new Employee(22,"divu",45778));
		for(Employee emp:t1)
		{
			System.out.println("employee name is "+emp.name);
			System.out.println("employee age is "+emp.age);
			System.out.println("employee salary is "+emp.salary);
			System.out.println("----------------------------------");
		}
		
	}

}
