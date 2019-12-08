
public class ExceptionChk {

	public static void main(String[] args) {
		Student s1=new Student();
		System.out.println("main started");
		try {
			Object o1=s1.clone();
			System.out.println("object is cloned");
			Class c1=Class.forName("Student");
			
			
		}catch(CloneNotSupportedException e) {
			System.out.println("clone not supported");
		}catch(ClassNotFoundException e) {
			System.out.println("class is not found");
		}
		System.out.println("main ended");
	}

}
