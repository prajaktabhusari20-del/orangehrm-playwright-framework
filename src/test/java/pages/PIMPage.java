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
	
	private String employeeNameSearch = "//label[text()='Employee Name']/../following-sibling::div//input";
	private String searchButton ="button[type='submit']";
    private String employeeRow =".oxd-table-card";
    private String lastNameSTextbox ="input[name='lastName']";
    private String saveSButton ="button[type='submit']";
    
    private String employeeCheckbox=".oxd-table-card .oxd-checkbox-input";
    private String deleteButton="button:has-text('Delete')";
    private String confirmDeleteButton="button:has-text('Yes, Delete')";
    private String successToast =".oxd-toast";
    
    public void selectEmployee() {
    	page.locator(employeeCheckbox).first().click();
    }
    
    public void deleteEmployee() {
    	page.locator(deleteButton).click();
    	page.locator(confirmDeleteButton).click();
    }
	
    public boolean isDeleteSucceful() {
    	page.locator(successToast).waitFor();
    	
    	return page.locator(successToast).textContent().contains("Successfully Deleted");
    }


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
	
	public void searchEmployee(String employeeName) {
		page.locator(employeeNameSearch).fill(employeeName);
		page.locator(searchButton).click();
	}
	public void openEmployee() {
		page.locator(employeeRow).first().click();
	}
	
	public void updateEmployee(String newLastName) {
		page.locator(lastNameSTextbox).fill(newLastName);
		page.locator(saveSButton).click();
	}

}
