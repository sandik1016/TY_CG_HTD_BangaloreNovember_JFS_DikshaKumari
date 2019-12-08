package localvar;

public class Car extends Vehicle {
int count=50000;
void carDetails() {
	int count=80000;
	System.out.println("local varialbe count is: "+count);
	System.out.println("Global variable count is: "+this.count);
	System.out.println("Parent class count is: "+super.count);
}
}
