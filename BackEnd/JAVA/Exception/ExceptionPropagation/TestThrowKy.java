

public class TestThrowKy {

	public static void main(String[] args) {
		System.out.println("main started");
		GoogleMap g = new GoogleMap();
		Ola o1 =  new Ola(g);
		o1.find(null);
		System.out.println("main ended");
		

	}

}
