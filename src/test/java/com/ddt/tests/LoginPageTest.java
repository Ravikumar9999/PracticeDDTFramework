package com.ddt.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ddt.base.TestBase;
import com.ddt.pages.HomePage;
import com.ddt.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		
	}
	
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Free CRM - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority = 2)
	public void freeCRMLogoImageTest() {
		boolean flag = loginPage.validateFreeCRMLogo();
		Assert.assertTrue(flag);
	}

	
	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
