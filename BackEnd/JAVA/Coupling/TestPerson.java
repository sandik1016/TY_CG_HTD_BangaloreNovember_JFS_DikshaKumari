
public class TestPerson {

	public static void main(String[] args) {
Person p1=new Person();
Bank b1=new Bank();
HDFC h=new HDFC();
ICICI i=new ICICI();
p1.amountWithdraw(h);//tightly coupling
	}

}
