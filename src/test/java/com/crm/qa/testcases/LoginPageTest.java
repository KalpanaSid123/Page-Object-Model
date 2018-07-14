package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;



import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() throws IOException
	{
		super();
		
	}
	

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		loginPage=new LoginPage();
		
	}
	@Test
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginPageTitle();
		
		AssertJUnit.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test
	public void loginpageLogoTest()
	{
		boolean flag=loginPage.validateCrmLogo();
	    AssertJUnit.assertTrue(flag);
	    
	}
	
	@Test
	public void logInTest() throws InterruptedException, IOException 
	{
	homePage=loginPage.logIn();
	}
	
	
		
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	}
