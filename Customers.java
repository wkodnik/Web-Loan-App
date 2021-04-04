package web.loan.test;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Customers {
	@Test(dataProvider = "CreateCustomer", dataProviderClass = CustomerDataProvider.class)

	public void AddCustomer(String branch, String branchAdmin, String branchPassword, String firstName, String lastName,
			String warning) {
		// TODO Auto-generated method stub
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

		// Try to sleep (wait) for 5 sec (using exception handler)
		try {

			Thread.sleep(5000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// Find the button 'Customers' by its id
		WebElement element = driver.findElement(By.id("ext-gen192"));

		// Click button 'Customers' under Main menu
		element.click();

		// Find the button 'Actions' by its xpath
		element = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/em[1]/button[1]"));

		// Click button 'Actions'
		element.click();

		// Find the button 'Add Customer' by its link text
		element = driver.findElement(By.linkText("Add Customer"));

		// Click button 'Add Customer'
		element.click();

		// Find the text input element 'FirstName' by its name
		element = driver.findElement(By.name("FirstName"));

		// Enter customer first name
		element.sendKeys(firstName);

		// Find the text input element 'LastName' by its name
		element = driver.findElement(By.name("LastName"));

		// Enter customer last name
		element.sendKeys(lastName);

		// Find web element button "Save"
		element = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]"));

		// Click "Save" button
		element.click();

		// try to sleep (wait) for 5 sec (using exception handler)
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			WebElement body = driver.findElement(By.tagName("body"));

			if (body.getText().contains("Customer '" + firstName + " " + lastName + "' already exists")) {
				System.out.println("Customer exists");
				// find button ok by xpath and click it to close pop up
				driver.findElement(By.xpath(
						"html/body/div[7]/div[2]/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]"))
						.click();

			} else if (body.getText().contains(warning) && !warning.isEmpty()) {
				System.out.println(warning);
				// find button ok by xpath and click it to close pop up

				driver.findElement(By.xpath(
						"html/body/div[7]/div[2]/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]"))
						.click();
				// Find button 'Cancel' by its xpath
				driver.findElement(By.xpath(
						"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[2]/em[1]/button[1]"))
						.click();

			} else {

				boolean ret = body.getText().contains(lastName);
				System.out.println(ret);

			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Find button 'Logout' by its xpath
		element = driver.findElement(By.xpath(
				"//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button"));

		// Click button 'Logout'
		element.click();

		// try to sleep (wait) for 5 sec (using exception handler)
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Close the browser
		driver.close();

	}

}
