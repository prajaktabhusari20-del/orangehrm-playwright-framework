package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtil;

import org.testng.Assert;

public class LoginTest extends BaseTest {
	
	@DataProvider(name="loginData")

	public Object[][] loginData() throws Exception {

	    return ExcelUtil.getExceldata(
	        "src/test/resources/testdata/LoginData.xlsx",
	        "Login");
	}
	
	@Test(dataProvider="loginData")
	public void verifyValidLogin(String username,String password) {
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		
		LoginPage loginPage =new LoginPage(page);
		
		loginPage.login(username,password);
		
		System.out.println( username + " " + password);
		
		//System.out.println(page.url());
		
		//assertThat(page).hasURL("**/dashboard/index");
	//Assert.assertTrue(page.url().contains("dashboard"));
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
