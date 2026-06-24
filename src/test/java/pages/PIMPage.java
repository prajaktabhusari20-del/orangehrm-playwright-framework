package pages;

import com.microsoft.playwright.Page;

public class PIMPage {
	private Page page;
	public PIMPage(Page page) {
		this.page=page;
	}
	
	private String pimMenu = "//span[text()='PIM']";
	private String addEmployeeButton = "//a[text()='Add Employee']";
	private String firstNameTextbox="input[name='firstName']";
	private String lastNameTextbox="input[name='lastName']";
	private String saveButton="button[type='submit']";
	
	public void clickPIM() {
		page.locator(pimMenu).click();
	}
	
	public void clickAddEmployee() {
		page.locator(addEmployeeButton).click();
	}
	
	public void addEmployee(String firstName,String lastName) {
		page.locator(firstNameTextbox).fill(firstName);
		page.locator(lastNameTextbox).fill(lastName);
		
		page.locator(saveButton).click();
		
	}

}
