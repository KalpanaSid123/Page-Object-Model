package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() throws IOException 
	{
		prop=new Properties();
	
			FileInputStream ip=new FileInputStream("C:\\Users\\Kalpana_Len\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		
		}
	
	
	public static void initialization() throws InterruptedException, IOException
	{
		//String browserName=prop.getProperty("browswer");
		
		
			System.setProperty("webdriver.chrome.driver", "C:\\Kalpu_Sel_2018\\Sel_Lav_Notes\\softwareDownlods\\chromedriver.exe");
		    driver=new ChromeDriver();
		
	        e_driver=new EventFiringWebDriver(driver);
	        eventListener=new WebEventListener();
	        e_driver.register(eventListener);
	        driver=e_driver;
	        
	        
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			
			System.out.println(prop.getProperty("username"));
			System.out.println(prop.getProperty("password"));
			System.out.println(prop.getProperty("url"));
			Thread.sleep(1000);
			driver.get("https://www.freecrm.com/index.html");
		}
		
	}

	
	

