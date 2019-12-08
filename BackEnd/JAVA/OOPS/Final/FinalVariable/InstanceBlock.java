
public class InstanceBlock {
  final int MAXIMUM;
  public InstanceBlock(){
	  System.out.println("Consructor is created");
  }
  public InstanceBlock(int a)
  {
  System.out.println("Overloaded Constructor is created");
  }
  {//IIB
	  System.out.println("Instance block is created");
	  this.MAXIMUM=3000;
  }
}
