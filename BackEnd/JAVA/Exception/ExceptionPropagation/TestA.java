
public class TestA {

	public static void main(String[] args) {
		System.out.println("main started");
		A.o();
System.out.println("main ended");
}

}
//if we are not using throw keyword then exception message of / by zero will come only one time as it is handled by a single class. so if handled no need of propagating.But if we use throw keyword then class is bounded to handled it in each class where it has been proapagated.