
public class Demo1 {
	public static void main(String args[]) {
		String s1="John";
		System.out.println("s1 hashcode value "+s1.hashCode());
		String s2="Mikel";
		s1="pinky";  //s1 has two different hashcode that means address is different
		String s3="John";//s1 and s3 are same
		System.out.println("s1 hashcode value "+s1.hashCode());
		System.out.println("s3 hashcode value "+s3.hashCode());
	}
}
