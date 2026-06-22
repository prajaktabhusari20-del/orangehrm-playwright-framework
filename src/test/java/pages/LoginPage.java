package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;
	
	public LoginPage(Page page) {
		this.page=page;
	}
	
	private String usernameTextbox = "input[name='username']";
	private String passwordTextbox = "input[name='password']";
	private String loginButton = "button[type='submit']";
	private String errorMessage= ".oxd-alert-content-text";
	
	public void enterUsername(String username) {
		page.locator(usernameTextbox).fill(username);
		
	}
	 public void enterPassword(String password) {
		 page.locator(passwordTextbox).fill(password);
	 }
	 
	 public void clickLogin() {
		 page.locator(loginButton).click();
	 }
	 
	 public void login(String username, String password) {
		 enterUsername(username);
		 enterPassword(password);
		 clickLogin();
	 }
	public String getErrorMessage() {
		return page.locator(errorMessage).textContent();
		
	}
	
}
