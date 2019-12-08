
public class StaticInstanceBlock {
 static final double PI;
 static {
	 System.out.println("static initialize block executed");
	 PI=3.142;
 }
}
