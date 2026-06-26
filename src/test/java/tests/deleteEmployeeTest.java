package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.PIMPage;

public class deleteEmployeeTest extends BaseTest {
	
	@Test
	public void verifyDeleteEmployee() {
		
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		
		LoginPage loginPage = new LoginPage(page);
		PIMPage pimPage = new PIMPage(page);
		
		loginPage.login("Admin","admin123");
		pimPage.clickPIM();
		pimPage.searchEmployee("Amelia");
		pimPage.selectEmployee();
		pimPage.deleteEmployee();
		
		Assert.assertTrue(pimPage.isDeleteSucceful());
		
		System.out.println("Deleted successfull");
	}

}
