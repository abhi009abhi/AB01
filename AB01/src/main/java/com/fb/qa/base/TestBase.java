package com.fb.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.fb.qa.fbutilities.TestUtility;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {
 public ExtentReports fbreports;
 public ExtentTest logger;
 File file;
 FileInputStream fis;
 Properties prop;
 public static WebDriver driver;
 public static EventFiringWebDriver efdriver;
 //public WebEventListner eventListner;
 public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();

 TestUtility childutil;
 public ExtentTest test;
 public ExtentReports extent;
 public String path = System.getProperty("user.dir")+"/Reports/FB/";

 
 
  public TestBase()
 {
	 try
	 {
		 prop = new Properties();
		 file = new File(System.getProperty("user.dir")+"/src/main/java/com/fb/qa/config/config.properties");
		 fis = new FileInputStream(file);
		 try
		 {
			 prop.load(fis);
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }
		 
	 }
	 catch(FileNotFoundException e)
	 {
		 e.printStackTrace();
	 }
	 
 }
 
 public void initialization()
 {
	 String browser = prop.getProperty("browser");
	 if(browser.equalsIgnoreCase("cHrome"))
	 {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get(prop.getProperty("url1"));
		 
	 }	 
	 if(browser.equals("firefox"))
	 {
		 System.setProperty("webdriver.chrome.driver","F:/Testing/Selenium/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     driver.get(prop.getProperty("url1"));
	 }	 
	 
/*	 efdriver = new EventFiringWebDriver(driver);
	 eventListner = new WebEventListner();
	 efdriver.register(eventListner);
	 driver= efdriver;
	 driver.get(prop.getProperty("url1"));*/
 }
 
 public void setDriver(WebDriver driver) {
		threadDriver.set(driver);
	}

	public WebDriver getDriver() {
		return threadDriver.get();
	}
 	
	
	
}//class
