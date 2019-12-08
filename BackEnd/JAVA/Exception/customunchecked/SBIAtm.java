package customunchecked;

public class SBIAtm {

	public static void main(String[] args) {
		System.out.println("main started");
		ATMSimulator a1 = new ATMSimulator();
		try {
			a1.withdraw(41000);
		}
		catch(DayLimitEexception ae) {
			System.out.println(ae.getMessage());
		}
		System.out.println("main ended");
	}

}
