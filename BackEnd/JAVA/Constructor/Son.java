
public class Son extends Father {
Son(){
	super("anuppu",98);
	System.out.println("C");
}
Son(String name,int age){
	this();
	System.out.println("D");
}
}
