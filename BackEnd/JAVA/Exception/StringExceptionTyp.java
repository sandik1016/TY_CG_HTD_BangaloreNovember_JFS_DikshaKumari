
public class StringExceptionTyp {
	
	void write() {
		String s=null;
		try {
			System.out.println("length of string is "+s.length());
			
		}catch(NullPointerException e) {
			System.out.println("dont deal with null");
		}
	}
	public static void main(String args[]) {
	  System.out.println("main started");
	  StringExceptionTyp set=new StringExceptionTyp();
	  set.write();
	  System.out.println("main ended");
	}

}
