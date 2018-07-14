package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;

import org.testng.Assert;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	
	
	//Every testcase should be seperated--independent to eath other
	//before each testcase -- launch the browser and login
	//@Test---execute the testcase
	//after each testcase---close the browser
	
	public HomePageTest() throws IOException
	{
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
		
    }
	
	
	@Test(priority=1)
	
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","title is not matching");
		
		
	}
	
    @Test(priority=2)
    
    public void verifyUserNameTest()
    {
    	testutil.switchToFrame();
    Assert.assertTrue(homePage.verifyUserNameLabel());
    }
    
    @Test
	public void verifyContactLinkTest() throws IOException
	{
    	testutil.switchToFrame();
    	contactsPage=homePage.clickOnContactLink();
	}

	
		@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}