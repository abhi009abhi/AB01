package com.fb.qa.extentrport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fb.qa.base.TestBase;

public class FBExtentReport extends TestBase
{
	 SimpleDateFormat fileNameFormat,dirNameFormat;
	   Date todaysDate;
	   File scrnPrint,dirExist,photo;
	   String fileName,dirName,saveFile,sendToDir;
	  

	
	public String getDateAsText()
	{
		todaysDate = new Date();
		fileNameFormat = new SimpleDateFormat("ddMMyyyyss");
		fileName = fileNameFormat.format(todaysDate);
		return fileName;	

	}
	
	public String createDir(String p) throws IOException
	{
		//String dir=null;
		todaysDate = new Date();
		dirNameFormat = new SimpleDateFormat("MMMyyyy");
		dirName = dirNameFormat.format(todaysDate);
		dirName = p+dirName;
		dirExist = new File(dirName);
		System.out.println("FileName is ::"+fileName);
		System.out.println("DirName is ::"+dirName);
		System.out.println("DirExist is ::"+dirExist);
		
		if(dirExist.exists())
		{
			System.out.println("Directory Presnt copying Now");
			dirExist.mkdirs();
			//dir="Directory Found";
		}
		else
		{  
			System.out.println("No Directory Found creating New");
			dirExist.mkdirs();
			//dir="Directory Created";
			
		}
		return dirName;
	}
	
	public File saveFile(String filePrefix,String dirpath) throws IOException
	  
	  {
		String reprtDir= createDir(dirpath);
		String reprtFile   =getDateAsText();
		System.out.println("send to dir ::"+reprtDir);
		System.out.println("save file ::"+reprtFile);
		File f = new File(reprtDir+"/"+filePrefix +reprtFile+".html");
		
		return f;
		
	  }
	
	public String savePhoto(String filePrefix,String dirpath) throws IOException
	  
	  {
		
		System.out.println("inside taking photo");
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		scrnPrint = screenShot.getScreenshotAs(OutputType.FILE);
		sendToDir = createDir(System.getProperty("user.dir"+"/Reports/Failed/"));
		saveFile   =getDateAsText();		
		photo = new File(sendToDir+"/"+saveFile+".jpeg");
		FileUtils.copyFile(scrnPrint, photo);
		
		return sendToDir+"/"+saveFile+".jpeg";
	  }
	

}
