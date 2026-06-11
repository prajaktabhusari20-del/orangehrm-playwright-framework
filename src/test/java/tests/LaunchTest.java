package tests;

import org.testng.annotations.Test;

import base.BaseTest;

public class LaunchTest extends BaseTest {
	
	@Test
	public void verifyApplicationLaunch() {
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		System.out.println(page.title());
		
	}

}
