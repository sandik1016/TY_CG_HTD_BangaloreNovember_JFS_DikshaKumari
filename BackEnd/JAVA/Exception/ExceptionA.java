package multiplecatch;

public class ExceptionA {
 void exception(int a ,String b) {//multiple cattchhhh blockssssss
	 try {
		 System.out.println(500/a);
		 System.out.println(b.length());
	 }catch(ArithmeticException e)
	 {
		 System.out.println("dont deal with 0");
	 }catch(NullPointerException n) {
		 System.out.println("dont deal with null");
	 }
 }
}
