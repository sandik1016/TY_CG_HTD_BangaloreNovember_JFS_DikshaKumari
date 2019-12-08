import java.util.Comparator;

public class EmployeeAge implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.age>o2.age)
			return 1;
		else if(o1.age<o1.age)
			return -1;
		
		return 0;//separate sorting logic we can provide for comparator
	}

}
