package com.fb.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fb.qa.base.TestBase;

import com.fb.qa.fbutilities.TestUtility;
import com.fb.qa.pages.FbLogin;

public class FbTest2 extends TestBase{
	FbLogin fb;
	TestUtility tutil;
	String path = System.getProperty("user.dir") + "/Photo/FB/";
	 
	 FbTest2() {
		super();
	}

	@BeforeTest
	public void precodnition() {
		initialization();
		System.out.println(driver);
		// setDriver(driver);
		// System.out.println(getDriver());
		fb = new FbLogin();
		tutil = new TestUtility();
		
	}

	 @Test
	public void EnterSignUpData() {
		logger = fbreports.createTest("Enter signup Data");

		logger.info("Entering Data into textbox");
		fb.enterSignUpDdata("Facebook007");
		logger.info("Data Entered Succesfully");
		fb.selectGender("Male");
		logger.info("Gender selected as Male");
		fb.enterDobDetails("13", "NOV", "1992");
		logger.info("Date entered success");
		// logger.info("Data entered succesfully");
		logger.pass("this is looger .pass");

	}

	@Test
	public void checkEnabledElements() throws IOException {
		logger = fbreports.createTest("Enter signup Data");
		boolean b = fb.enableElements();
		// Assert.assertEquals(b,true);
		if (b == false) {
			System.out.println("inside Pass");
			logger.pass("elements are enabled");
		}
		if (b == true) {
			System.out.println("inside fail");
			tutil.savePhoto("FBElements", path);
			
			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath("F:\\Testing\\PHOTON\\FW\\Reports\\FB\\Feb2020"+"1.png").build());

		}
	}

	 @Test(invocationCount=1)
	public void takePhoto() throws IOException {
		logger = fbreports.createTest("Taking screen Print");
		tutil.savePhoto("Fblogin", path);
		logger.pass("Photo Taken");
	}

	@AfterTest
	public void postCondition() {
		System.out.println("inside post condition");
		driver.close();
	}

}
