
public class Demo3 {
	public static void main(String[] args) {
		String s1="John";
		System.out.println(s1.toLowerCase());//lowercase
		System.out.println(s1.toUpperCase());//uppercase 
		System.out.println(s1.length());//length
		String s2="  John Mikel ";
		System.out.println(s2.trim());//trim
		String s4=s1.substring(3);//substring
		System.out.println(s4);
		String s5="sudhanshu";
		System.out.println(s5.substring(3,6));
		System.out.println(s5.isEmpty());//isEmpty
		String s6="ShreeShree";
		System.out.println(s6.charAt(4));//charAt
		System.out.println(s6.indexOf('h'));//index
		System.out.println(s6.indexOf("re"));
		System.out.println(s6.indexOf('h',4));
		System.out.println(s6.indexOf("re",4));
		
	}
}
