//author Kalpana
package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
		WebElement contactLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//td[contains(text(),'Raju Pop')]")
	WebElement newContactLabel;
	
	
	
	
	//@FindBy(xpath="//a[text()='Kalpu Sid']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")
	//WebElement 
	
	public ContactsPage() throws IOException
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyContactLabel()
	{
		return contactLabel.isDisplayed();
	}
	
	
	public void createNewContact(String title,String fname,String lname,String comp)
	{
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(comp);
		saveBtn.click();
	}
	
	public boolean verifyAddedContact()
	{
		return newContactLabel.isDisplayed();
	}
	
	public void selectContactByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
	
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
}
}