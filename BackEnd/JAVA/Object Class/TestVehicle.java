
public class TestVehicle {
public static void main(String args[]) throws CloneNotSupportedException {
	Vehicle v1=new Vehicle("benz");
	Object o1=v1.clone();//upcasting
	Vehicle v2=(Vehicle)o1;//create another new object with previous value is known as clone//downcasting 
	System.out.println(v2.vehicleName);
}
}
