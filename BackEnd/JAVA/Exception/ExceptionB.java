
public class ExceptionB {

	void exception(int a,String b ) {//nested try
		try {
			System.out.println(10/0);
		
		try {
			System.out.println(500/a);
		}catch(ArithmeticException a1) {
			System.out.println("dont deal with zero");
		}
	}catch(NullPointerException e)
	{
		System.out.println("dont deal with null");
	}
}
}
