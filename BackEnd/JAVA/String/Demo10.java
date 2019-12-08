
public class Demo10 {
	public static void main(String[] args) {
		StringBuilder s1= new StringBuilder("JOHN");
		System.out.println(s1.hashCode());
		s1 = s1.append("Mikel");
		System.out.println(s1.hashCode());
	}
}
