package tests;

import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;

public class LoginTest extends BaseTest {
	
	@Test
	public void verifyValidLogin() {
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		
		LoginPage loginPage =new LoginPage(page);
		
		loginPage.login("Admin", "admin123");
		
		//System.out.println(page.url());
		
		//assertThat(page).hasURL("**/dashboard/index");
	Assert.assertTrue(page.url().contains("dashboard"));
	}
	
	/*@Test
	public void verifyInvalidLogin() {
page.navigate("https://opensource-demo.orangehrmlive.com/");
		
		LoginPage loginPage =new LoginPage(page);
		
		loginPage.login("Admi", "admin13");
		String actualMessage = loginPage.getErrorMessage();
		Assert.assertEquals(actualMessage, "Invalid credentials");
	}*/
	

}
