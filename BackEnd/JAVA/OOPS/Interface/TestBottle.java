
public class TestBottle {

	public static void main(String[] args) {
		Fanta f=new Fanta();
		f.open();
		f.drink();
		Pepsi p=new Pepsi();
		p.drink();
		p.open();
		p.juice();//defult methd
		Bottle.close();   //static method

	}

}
