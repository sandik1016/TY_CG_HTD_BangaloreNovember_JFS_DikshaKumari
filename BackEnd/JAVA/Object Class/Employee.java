
public class Employee {
int empID;
String empName;
@Override
public String toString() {
	return "Employee [empID=" + empID + ", empName=" + empName + "]";
}
public Employee(int empID, String empName) {
	super();
	this.empID = empID;
	this.empName = empName;
}

}
