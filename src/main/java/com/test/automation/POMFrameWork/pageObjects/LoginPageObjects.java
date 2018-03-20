package com.test.automation.POMFrameWork.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.POMFrameWork.loginPageTest.LoginPage_TestCases;

public class LoginPageObjects {

	public static final Logger log = Logger.getLogger(LoginPageObjects.class.getName());

	@FindBy(xpath="//*[@id='email']")
	WebElement emailAddress;

	@FindBy(xpath="//*[@id='passwd']")
	WebElement password;

	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement login_signInButton;
	
	@FindBy(xpath="//*[text()='Authentication failed.']")
	WebElement AuthenticationFailed;

	public LoginPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String email){
		emailAddress.clear();
		log.info("clearing email address field");
		emailAddress.sendKeys(email);
		log.info("entered email address is "+email + "and object is "+emailAddress.toString());
	}

	public void enterPassword(String pass){
		password.clear();
		log.info("clearing password field");
		password.sendKeys(pass);
		log.info("entered password is "+pass+ "and the object is "+password.toString());
	}

	public void clickOnSignInButton(){
		login_signInButton.click();
		log.info("clicked on sign in button and the object is "+ login_signInButton.toString());
	}
	
	public String AuthenticationFailedText(){
		log.info("error message is "+AuthenticationFailed.getText());
		return AuthenticationFailed.getText();
		
	}

	public void loginToApplication(String email, String pass){
		enterEmail(email);
		enterPassword(pass);
		clickOnSignInButton();
	}
}
