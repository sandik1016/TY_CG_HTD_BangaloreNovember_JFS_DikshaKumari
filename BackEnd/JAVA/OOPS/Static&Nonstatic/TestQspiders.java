package staticAndNonstatic;

public class TestQspiders {

	public static void main(String[] args) {
		Qspiders oar=new Qspiders();
		Qspiders btm=new Qspiders();
		oar.swipe();
		btm.swipe();
		System.out.println(oar.branchCount);
		System.out.println(btm.branchCount);
		System.out.print(Qspiders.totalCount);

	}

}
