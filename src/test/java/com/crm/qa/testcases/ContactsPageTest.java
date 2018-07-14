package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	
	String sheetname="contacts";
	

	public ContactsPageTest() throws IOException {
		super();
	}

	 @BeforeMethod
		public void setUp() throws IOException, InterruptedException
		{
			initialization();
			loginPage=new LoginPage();
			testutil=new TestUtil();
		    contactsPage=new ContactsPage();
			homePage=loginPage.logIn();
			
			testutil.switchToFrame();
			contactsPage=homePage.clickOnContactLink();
			
			
	    }
	 
	 @Test(priority=1)
	 public void verifyContactLabelTest()
	 {
		 Assert.assertTrue(contactsPage.verifyContactLabel(),"Contacts label is not matching");
	 }
	 
	 
	 @Test(priority=2)
	 
	public void verifyselectSingleContactByNameTest()
	{
		 contactsPage.selectContactByName("Kalpu Sid");
	}
	 
	 
	 @Test(priority=3)
	 
	public void verifyselectMultipleContactByNameTest()
	{
		 contactsPage.selectContactByName("Kalpu Sid");
		 contactsPage.selectContactByName("Kavi gouru");
		 
	}
	 
	 @DataProvider
	 
	 public Object[][] getFreeCrmTestData()
	 {
		 Object data[][]=TestUtil.getTestData(sheetname);
		return data;
		 
	 }
	 
	 
	 
	 @Test(dataProvider="getFreeCrmTestData")
	 public void verifyAddNewContactTest(String title,String firstName,String lastName,String company)
	 {
		 homePage.clickOnAddNewContactLink();
		 
		 //contactsPage.createNewContact("Mr.","Sam","John","facebook");
		 contactsPage.createNewContact(title,firstName,lastName,company);
		// Assert.assertTrue(contactsPage.verifyAddedContact());
	 }
	 
	 
	 
	 

		@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}

	
	
}
