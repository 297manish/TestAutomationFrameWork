package com.test.automation.POMFrameWork.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.POMFrameWork.testBase.TestBase;

public class test extends TestBase{

	@BeforeClass
	public void setUp(){
		selectBrowser("chrome");
		openUrl("https://www.google.com");
	}

	@AfterClass
	public void endTest(){
		closeBroswser();
	}

	@Test
	public void verifyTitleOfPage(){
		Assert.assertTrue(driver.getTitle().contains("xxx"));
	}
}
