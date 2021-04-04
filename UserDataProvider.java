package web.loan.test;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

  @DataProvider
  public static Object[][] CreateUser(){
    return new Object[][] {
  
      new Object[]{"Nain", "admin", "lmenshun0721", "jroberts2", "pasword", "" },
      new Object[]{"Nain", "admin", "lmenshun0721", "", "pasword", "Mandatory field 'Username' is empty"},
      new Object[]{"Nain", "admin", "lmenshun0721", "samplename", "", "Mandatory field 'Password' is empty"},
    };
  }
}
