package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//td[contains(text(),'User: Kalpana Siddapuram')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyHomePageTitle()
	{
		
		String tit =driver.getTitle();
		System.out.println(tit);
		return tit;
	}
	
	public boolean verifyUserNameLabel()
	{
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactLink() throws IOException
	{
		contactLink.click();
		return new ContactsPage();
	}
	
	public void clickOnAddNewContactLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		newContactLink.click();
		
	}
	
	public DealsPage clickOnDealsLink()
	{
		contactLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTaskstLink()
	{
		contactLink.click();
		return new TasksPage();
	}
	
}
