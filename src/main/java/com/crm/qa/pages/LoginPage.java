package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase {
	
	

	//PageFactory--OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@alt,'free crm logo')]")
	WebElement crmLogo;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement signUpBtn;
	

	
	public LoginPage() throws IOException
	{
		PageFactory.initElements(driver,this);
	}

	
	//Actions
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCrmLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage logIn() throws InterruptedException, IOException
	{
		username.sendKeys("Kalpu123");
		password.sendKeys("Kalpu123");
		Thread.sleep(1000);
	    loginBtn.click();
	    
	    return new HomePage();
		
	}
	
}
