package com.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	 public static WebDriver driver;
     public static ExtentReports report;
     public static ExtentSparkReporter spark;
     public static ExtentTest test;
     
	 public WebDriver initialization() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		return driver;
	 }
	 public void reportInitializer() {
		 report = new ExtentReports();
		 spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		 report.attachReporter(spark);
	 }
	 public String getscreenshot(String TestCaseName) {
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		 String name = TestCaseName+"------"+sdf.format(new Date());
		 String path = System.getProperty("user.dir")+"/src/test/resources/screenshots/"+name+".jpg";
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return path;
 }
}
