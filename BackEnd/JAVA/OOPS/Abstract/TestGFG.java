
public class TestGFG {
	public static void main(String args[]) {
		ExtendedGFG e=new ExtendedGFG();
		e.sum=30;
		System.out.println(e.sum);
		GfG.count=0;
		System.out.println(GfG.count);
		e.drink();
		e.eat();
	}
}
