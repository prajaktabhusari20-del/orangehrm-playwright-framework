package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AdminPage;
import pages.LoginPage;

public class AdminTest extends BaseTest {
	
	@Test
	public void verifyAdminSearch() {
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		LoginPage loginPage = new LoginPage(page);
		loginPage.login("Admin","admin123");
		
		AdminPage adminPage =new AdminPage(page);
		adminPage.clickAdminMenu();
		adminPage.enterUsername("Admin");
		//page.waitForTimeout(50000);
		//System.out.println(page.url());
		adminPage.clickSearch();
		page.waitForTimeout(50000);
		System.out.println(adminPage.getSearchResultCount());

		Assert.assertTrue(adminPage.getSearchResultCount() > 0);
		System.out.println("Search completed");
		//System.out.println("Count = " + adminPage.getSearchResultCount());
		
	}

}
