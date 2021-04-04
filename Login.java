package web.loan.test;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	@Test
	public void LMSLogin(WebDriver driver, String branch, String branchAdmin, String branchPassword) {
	// Open LMS login page
	
	// TODO Auto-generated method stub
			

			// And now use this to visit LMS login page
			driver.get("http://test-hitekschool.com/lms/loans/2108");

			// Maximize window
			driver.manage().window().maximize();

			// Read the title of the page and put it into results
			System.out.println("Page title is: " + driver.getTitle());

			// Find the text input element 'branch' by its name
			WebElement element = driver.findElement(By.name("j_branch"));

			// Enter username
			element.sendKeys(branch);

			
			// Find the text input element 'username' by its name
			element = driver.findElement(By.name("j_username"));

			// Enter username
			element.sendKeys(branchAdmin);

			// Find the text input element 'password' by its name
			element = driver.findElement(By.name("j_password"));

			// Enter password
			element.sendKeys(branchPassword);

			// Find the button Login by its id
			element = driver.findElement(By.id("ext-gen38"));
			
			

			// Click Login button
			element.click();
			
	        // try to sleep (wait) for 5 sec (using exception handler)
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Read the title of the page and output it into results
	        System.out.println("Page title is: " + driver.getTitle());

	        // Verify the title of the page
		Assert.assertEquals(driver.getTitle(), "Loan Management System - '" + branch + "' branch");
	        

	        // try to sleep (wait) for 5 sec (using exception handler)
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}
}
