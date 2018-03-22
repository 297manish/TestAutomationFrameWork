package com.test.automation.POMFrameWork.loginPageTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.POMFrameWork.config.Config;
import com.test.automation.POMFrameWork.pageObjects.HomePageObjects;
import com.test.automation.POMFrameWork.pageObjects.LoginPageObjects;
import com.test.automation.POMFrameWork.testBase.TestBase;

public class LoginPage_TestCases extends TestBase {
	
	public static final Logger log = Logger.getLogger(LoginPage_TestCases.class.getName());
	HomePageObjects hpo ;
	LoginPageObjects lpo ;
	Config c = new Config();
	
	@BeforeClass
	public void setUp(){
		selectBrowser("chrome");
		applyImplicitWait(20);
		hpo = new HomePageObjects(driver);
		lpo = new LoginPageObjects(driver);
		openUrl(c.setUrl());
		
	}
	
	@AfterClass
	public void end(){
		log.info("closing browser");
		driver.close();
	}
	
	@Test
	public void loginWithInvalidCredentisls() throws IOException{
		log.info("starting loginWithInvalidCredentisls test");
		hpo.clickOnSignInButton();
		lpo.loginToApplication("test@gmail.com", "12345");
		Assert.assertEquals(lpo.AuthenticationFailedText(), "Authentication failed.");
		log.info("finish loginWithInvalidCredentisls test");
		getScreenShot("loginWithInvalidCredentisls");
	}
}
