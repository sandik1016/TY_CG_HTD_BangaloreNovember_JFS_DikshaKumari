package overloading;

public class TestCalculator {

	public static void main(String[] args) {
		Calculator c1=new Calculator();
		double r1=c1.add(23.46);
		int r2=c1.add(67);
		int r3=c1.add(34,84);
        System.out.println("result of r1:"+r1);
        System.out.println("result of r2:"+r2);
        System.out.println("result of r3:"+r3);
        int c=Calculator.multiply(23);
        int c2=c1.multiply(22,4);
        double c3=Calculator.multiply(22.33);
        System.out.println("result of c:"+c);
        System.out.println("result of c2:"+c2);
        System.out.println("result of c3:"+c3);
	}

}








