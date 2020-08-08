package com.fb.qa.pages;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class FbLogin extends TestBase
{
 /* By firstName    = By.id("u_0_m");
  By lastName     = By.name("lastname");
  By emailOrPhone = By.xpath("//input[@id='email']");
  By passWord     = By.className("inputtext _58mg _5dba _2ph-");
  By date         = By.xpath("//select[@id='day']");
  By month        = By.cssSelector("");
  By year         = By.xpath("//select[@id='year']");*/
  
  //WebElement fname,sname,pwd,PhoneOrEmail;
//Select syear    = new Select(year);
//id,name,xpath,className,tagName,cssSelector,Select
   SimpleDateFormat fileNameFormat,dirNameFormat;
   Date todaysDate;
   File scrnPrint,dirExist;
   String fileName,dirName;
   @FindBy(name="firstname")
    WebElement Fname;
  
  @FindBy(name="lastname")
  WebElement sname;
  
  @FindBy(xpath="//input[@name='reg_email__']")
  WebElement phoneOrEmail;
  
  @FindBy(xpath="//input[@name='reg_passwd__']")
  WebElement pwd;
  
  @FindBy(xpath ="//select[@name='birthday_day']/option")
  List<WebElement> dobDate;
  
  @FindBy(xpath = "//select[@name='birthday_month']/option")
  List<WebElement> dobMonth;
  
  @FindBy(xpath="//select[@name='birthday_year']/option")
  List<WebElement> dobYear;
  
  @FindBy(xpath="//span[@id='u_0_z']/span/label")
  List<WebElement> gender;
 
 
  
  public FbLogin()
  {
	System.out.println("driver trafered succefully to page"+driver); 
	PageFactory.initElements(driver,this);
  }
  
  public boolean enableElements()
  {
	 if( 
	  Fname.isEnabled()&&
	  sname.isEnabled()&&
	  phoneOrEmail.isEnabled()&&
	  pwd.isEnabled()
	  )
	 {
		 return true;
	 }
  return false;}
  
  public void enterSignUpDdata(String a)
  {
	 System.out.println("yeah");
	 System.out.println(Fname);
	 Fname.clear();
	 Fname.sendKeys(a);	 
	 sname.clear();
	 sname.sendKeys(a);
	 phoneOrEmail.clear();
	 phoneOrEmail.sendKeys(a);
	 pwd.clear();
	 pwd.sendKeys(a);

  }
  
  public void selectGender(String gen)
  {
	for(int i=0;i<gender.size();i++)
	{
		if(gender.get(i).getText().equals(gen))
		{
			gender.get(i).click();
		}
	}	
  }
  
  public void enterDobDetails(String Date,String month,String year)
  {
	  System.out.println(year);
	  	  for(WebElement list:dobDate)
		{
			if(list.getText().equals(Date))
			{
				list.click();
			}
		}
	  	  
	  	for(WebElement mon:dobMonth)
		{ 
	  		
			if(mon.getText().equalsIgnoreCase(month))
			{
				mon.click();
			}
		}
	  	for(WebElement yr:dobYear)
		{ 
	  		
			if(yr.getText().equalsIgnoreCase(year))
			{
				yr.click();
			}
		}
	  	
  }
 
  
  
}
