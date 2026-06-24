package pages;

import com.microsoft.playwright.Page;

public class AdminPage {
	private Page page;
	
	public AdminPage(Page page) {
		this.page=page;
		
	}
	private String adminMenu="//span[text()='Admin']";
	private String usernameTextBox="(//input[contains(@class,'oxd-input')])[2]";
	private String searchButton="button[type='submit']";
	
	
	public void clickAdminMenu() {
		page.locator(adminMenu).click();
		
	}
	
	public void enterUsername(String username) {
		page.locator(usernameTextBox).fill(username);
		
	}
	
	public void clickSearch() {
		page.locator(searchButton).click();
	}
	
	public void searchUser(String username){
		enterUsername(username);
		clickSearch();
	}
	
	public boolean isUserDisplayed() {
		page.locator(".oxd-table-card")
        .first()
        .waitFor();
		return page.locator(".oxd-table-card").count()>0;
		
		
	}
	
	public int getSearchResultCount() {

	    return page.locator(".oxd-table-card").count();

	}

}
