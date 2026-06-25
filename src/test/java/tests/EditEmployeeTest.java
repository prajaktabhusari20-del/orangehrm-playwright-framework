package tests;
import java.util.regex.Pattern;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import base.BaseTest;
import pages.LoginPage;
import pages.PIMPage;

public class EditEmployeeTest extends BaseTest {
	
	@Test
	public void verifyEditEmployee() {
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		
		LoginPage loginPage=new LoginPage(page);
		
		PIMPage pimPage=new PIMPage(page);
	
		loginPage.login("Admin","admin123");
		pimPage.clickPIM();
		pimPage.searchEmployee("Admin");
		pimPage.openEmployee();
		pimPage.updateEmployee("Bhusarii");
		assertThat(page).hasURL(Pattern.compile(".*viewPersonalDetails.*") );
		System.out.println("Employee updated successfully");
	}

}
