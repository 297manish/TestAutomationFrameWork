package com.test.automation.POMFrameWork.homepageTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.POMFrameWork.loginPageTest.LoginPage_TestCases;
import com.test.automation.POMFrameWork.pageObjects.HomePageObjects;

public class HomePage_TestCases {
	public static final Logger log = Logger.getLogger(LoginPage_TestCases.class.getName());
	WebDriver driver;
	HomePageObjects hpo;
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		hpo = new HomePageObjects(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}
	
	@Test
	public void verifyTitleOfHomePage(){
		Assert.assertEquals(driver.getTitle(), "My Store");
	}
	
	@AfterClass
	public void end(){
		driver.close();
	}
}
