package com.crm.qa.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestTestBase{
	
	public static Properties prop;
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
	
            prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\Kalpana_Len\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
			
			String urlname=prop.getProperty("url");
			System.out.println("url is"+urlname);
			System.out.println(prop.getProperty("username"));
			

			System.setProperty("webdriver.chrome.driver", "C:\\Kalpu_Sel_2018\\Sel_Lav_Notes\\softwareDownlods\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.get("https://www.freecrm.com/index.html");
			
		

		
	}
}

