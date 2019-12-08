
public class Demo9 {
	public static void main(String[] args) {
		String s1 = new String("john");
		System.out.println(s1.hashCode());
		s1 = s1.concat("Marsh");
		System.out.println(s1.hashCode());
	}
}
