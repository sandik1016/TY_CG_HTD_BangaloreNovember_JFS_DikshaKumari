
public class TestStudent {

	public static void main(String[] args) {
		Student s1=new Student();
		System.out.println(s1.studAge);
		System.out.println(s1.studName);
		Student s2=new Student("raveeshsir",37);
		System.out.println(s2.studAge);
		System.out.println(s2.studName);
	}

}
