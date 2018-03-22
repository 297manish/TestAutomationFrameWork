package com.test.automation.POMFrameWork.homepageTest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.automation.POMFrameWork.config.Config;
import com.test.automation.POMFrameWork.loginPageTest.LoginPage_TestCases;
import com.test.automation.POMFrameWork.pageObjects.HomePageObjects;
import com.test.automation.POMFrameWork.testBase.TestBase;

public class HomePage_TestCases extends TestBase{
	public static final Logger log = Logger.getLogger(LoginPage_TestCases.class.getName());
	WebDriver driver;
	HomePageObjects hpo;
	Config c = new Config();

	@BeforeClass
	public void setUp(){
		selectBrowser("chrome");
		hpo = new HomePageObjects(driver);
		openUrl(c.setUrl());
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
