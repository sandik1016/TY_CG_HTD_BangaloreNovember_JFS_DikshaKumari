
public class TestCalc {
     public static void main(String args[]) {
    	 System.out.println("main started");
    	 Calculator c1=new Calculator();
    	 c1.divide(10, 0);//(unchecked exception )arithmetic exception
    	 System.out.println("main ended");
     }
}
