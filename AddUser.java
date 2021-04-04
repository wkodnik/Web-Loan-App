package web.loan.test;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddUser {
	@Test(dataProvider = "CreateUser", dataProviderClass = UserDataProvider.class)
	public void AddUser_(String branch, String branchAdmin, String branchPassword, String username, String password, String warning) {
		// TODO Auto-generated method stub
		
		int numberOFMilliseconds = 5000;
		
		System.setProperty("webdriver.chrome.driver", "/home/lyuda/Downloads/chromedriver");
		// Create a new instance of the chrome driver
		WebDriver driver = new ChromeDriver();

		// And now use this to visit LMS login page
		// driver.get("http://test-hitekschool.com/lms/loans/2108");

		// Create instance of class Login to use its LMSLogin method in our Add User
		// scenario
		Login login = new Login();

		// Login to LMS - using LMSLogin method of class Login and passing 'driver'
		// argument to the method to re-use Firefox browser already opened
		login.LMSLogin(driver, branch, branchAdmin, branchPassword);

		sleep(numberOFMilliseconds);

		// Find the button 'Users' by its id
		WebElement element = driver.findElement(By.id("ext-gen185"));

		// Click button 'Users' under Main menu
		element.click();

		// Find the button 'Actions' by its xpath
		element = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/em[1]/button[1]"));

		// Click button 'Actions'
		element.click();

		// Find the button 'Add User' by its link text
		element = driver.findElement(By.linkText("Add User"));

		// Click button 'Add User'
		element.click();

		// Find the text input element 'username' by its name
		element = driver.findElement(By.name("Username"));

		// Enter username
		element.sendKeys(username);

		// Find the text input element 'password' by its name
		element = driver.findElement(By.name("Password"));

		// Enter password
		element.sendKeys(password);

		// Find web element button "Save"
		element = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/em[1]/button[1]"));
		// element =
		// driver.findElement(By.xpath("//div[5]/div/div[2]/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/em/button"));
		// element = driver.findElement(By.name("Save"));

		sleep(numberOFMilliseconds);

		// Click button 'Save'
		element.click();

		sleep(numberOFMilliseconds);

		if (warning != "") {

			doesTextExistOnPage(warning, driver);

			// find buton ok by xpath and click it to close pop up
			driver.findElement(By.xpath("//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]")).click();
			///html[1]/body[1]/div[52]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]
			// Find button 'Cancel' by its xpath
			element = driver.findElement(
					By.xpath("//div[5]/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button"));

			// Click button 'Cancel'
			element.click();

		} else {

			doesTextExistOnPage(username, driver);

		}

		// Find button 'Logout' by its xpath
		element = driver.findElement(By.xpath(
				"//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button"));

		// Click button 'Logout'
		element.click();

		sleep(numberOFMilliseconds);

		// Close the browser
		driver.close();

	}

	private boolean doesTextExistOnPage(String textToLookFor, WebDriver driver) {
		WebElement body = driver.findElement(By.tagName("body"));
		boolean ret = body.getText().contains(textToLookFor);
		System.out.println(ret);
		return ret;
	}

	private void sleep(int numberOFMilliseconds) {
		try {

			Thread.sleep(numberOFMilliseconds);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}
	}

}
