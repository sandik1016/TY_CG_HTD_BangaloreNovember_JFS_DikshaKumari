package customunchecked;

public class DayLimitEexception extends Exception{
	String msg="exceeds amount";

	public DayLimitEexception() {
		super();
	}

	public DayLimitEexception(String msg) {
		super();
		this.msg = msg;
	}
	public String  getMessage() {
		return msg;
	}

}
