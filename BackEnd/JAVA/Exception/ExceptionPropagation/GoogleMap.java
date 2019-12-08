

public class GoogleMap {
	
	void findLocation(String loc) {
		try{
			System.out.println(loc.length());
		}catch(NullPointerException n) {
			System.out.println("google map user plz fill the location name");
			throw n;//throw keyword used to throw exception object
		}
	}

}
