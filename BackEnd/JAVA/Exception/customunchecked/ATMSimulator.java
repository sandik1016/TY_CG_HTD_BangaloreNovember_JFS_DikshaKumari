package customunchecked;

public class ATMSimulator {
   void withdraw(double amount) throws DayLimitEexception {
	   if(amount>40000)
	   {
		  
			throw new DayLimitEexception("amount is exceeded");
		
		
	  
   }
}
}
