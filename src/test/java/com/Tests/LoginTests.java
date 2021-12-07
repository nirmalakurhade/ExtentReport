package com.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;

import net.bytebuddy.dynamic.NexusAccessor.InitializationAppender;

public class LoginTests extends BaseClass{
     WebDriver driver;
	@BeforeSuite
	public void setup() {
		driver = initialization();
		reportInitializer();
	}
	@Test 
	public void loginPass() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | DashBoard");
		
	}
	@Test 
	public void loginfail() {
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | Log in");
	}
	@Test 
	public void loginskip() {
		throw new SkipException("skipping a test case");
	}
}
