package com.ect.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ect.utilities.BrowserFactory;
import com.ect.utilities.ConfigDataClass;
import com.ect.utilities.ReadExcelFile;

public class BaseClass {
	
	String fileName=System.getProperty("user.dir") +  "\\TestData\\ETestData.xlsx";
	public WebDriver driver;
	public ConfigDataClass config= new ConfigDataClass();

	public ReadExcelFile rf=new ReadExcelFile();
	
	protected LoginPages lp;
	protected String username=ReadExcelFile.getCellValue(fileName, "Login",1, 0);
	protected String password=ReadExcelFile.getCellValue(fileName, "Login",1, 1);
	@BeforeClass
	public void setup() {
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getUrl());
		
	}

	 public void captureScreenShot(WebDriver driver,String testName) throws IOException
	 {
		 // Convert webdriver object to TakesScreenshot interface
		 TakesScreenshot screenshot= ((TakesScreenshot)driver);
		 
		 // Step 2 :call getScreenshotAs method to capture image file
		 
		 File src= screenshot.getScreenshotAs(OutputType.FILE);
		 File srcpath=new File("."+"//ScreenShots//"+ testName + ".png");
		 
		 // Step 3 : copy image file to destination 
		 FileUtils.copyFile(src, srcpath);
		 
	 }
}
