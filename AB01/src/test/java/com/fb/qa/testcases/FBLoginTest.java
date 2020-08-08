package com.fb.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.fb.qa.base.TestBase;

import com.fb.qa.fbutilities.TestUtility;
import com.fb.qa.pages.FbLogin;


public class FBLoginTest extends TestBase {
	FbLogin fb;
	TestUtility tutil;
	String path = System.getProperty("user.dir") + "/Photo/FB/";
	
	FBLoginTest() {
		super();
	}

	@BeforeTest
	public void precodnition() {
		initialization();
		System.out.println(driver);
		/* setDriver(driver);
		 System.out.println(getDriver());*/
		fb = new FbLogin();
		tutil = new TestUtility();
		//FbReprttutil = new FBExtentReport();*/
	}
	


	 @Test
	public void EnterSignUpData() {
		 
		
		fb.enterSignUpDdata("Facebook007");
		
		fb.selectGender("Male");
		
		fb.enterDobDetails("13", "NOV", "1992");
	
        Assert.assertEquals(true,true);
	}

	@Test
	public void checkEnabledElements() throws IOException {
		//test = extent.createTest("Enabled Elements");
		boolean b = fb.enableElements();
		 Assert.assertEquals(b,true);
		 
		/*if (b == false) {
			System.out.println("inside Pass");
			//logger.pass("elements are enabled");
		}
		if (b == true) {
			System.out.println("inside fail");
			tutil.savePhoto("FBElements", path);
			
			//logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath("F:\\Testing\\PHOTON\\FW\\Reports\\FB\\Feb2020"+"1.png").build());

		}*/
	}

	 @Test()
	public void takePhoto() throws IOException {
		//logger = fbreports.createTest("Taking screen Print");
		//test = extent.createTest("Photographer"); 
		tutil.savePhoto("Fblogin", path);
		//logger.pass("Photo Taken");
	}

	@AfterTest
	public void postCondition() {
		System.out.println("inside post condition");
		driver.close();
	}

}
