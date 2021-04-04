package web.loan.test;

import org.testng.annotations.DataProvider;

public class CustomerDataProvider {

	
	@DataProvider
	  public static Object[][] CreateCustomer(){
	    return new Object[][] {
	  
	      new Object[]{"Nain", "admin", "lmenshun0721", "Bella", "Donna", "" },
	      new Object[]{"Nain", "admin", "lmenshun0721", "Bella", "Donna", "" },
	      new Object[]{"Nain", "admin", "lmenshun0721", "", "Roberts", "Mandatory field 'First Name' is empty"},
	      new Object[]{"Nain", "admin", "lmenshun0721", "Julia", "", "Mandatory field 'Last Name' is empty"},
	    };
	  }
}
