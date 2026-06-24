package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.assertions.PageAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import base.BaseTest;
import pages.LoginPage;
import pages.PIMPage;
import java.util.regex.Pattern;

public class PIMTest extends BaseTest {
	
	@Test
	public void verifyAddEmployee() {
		
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		
		LoginPage loginPage = new LoginPage(page);
		PIMPage pimPage = new PIMPage(page);
		
		loginPage.login("Admin","admin123");
		pimPage.clickPIM();
		pimPage.clickAddEmployee();
		pimPage.addEmployee("Prajakta", "Bhusari");
		/*page.waitForURL("**viewPersonalDetails**");
		Assert.assertTrue(page.url().contains("viewPersonalDetails"));*/
		assertThat(page)
	    .hasURL(
	        Pattern.compile(".*viewPersonalDetails.*"),
	        new PageAssertions.HasURLOptions()
	            .setTimeout(15000)
	    );
		
		System.out.println("Employee Added");
		
	}

}
