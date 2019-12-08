
public class Vehicle implements Cloneable{
  String  vehicleName;
  public Vehicle(String vehicleName) {
	  this.vehicleName=vehicleName;
  }
  @Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
  
}
