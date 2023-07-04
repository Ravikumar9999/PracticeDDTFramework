package com.ddt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ddt.base.TestBase;

public class LoginPage extends TestBase {
	

	
	@FindBy(name = "username")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement passWord;
	
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div/div/input")
	WebElement loginBtn;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/a/img")
	WebElement crmLogo;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean validateFreeCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	
	public HomePage login(String un, String pwd) {
		userName.sendKeys(un);
		passWord.sendKeys(pwd);
		loginBtn.click();
		
		
		return new HomePage();
	}
	
	
}
