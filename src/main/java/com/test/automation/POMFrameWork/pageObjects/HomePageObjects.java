package com.test.automation.POMFrameWork.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects{

	

	@FindBy(xpath = "//a[contains(text(), 'Sign in')]")
	WebElement homepage_signInButton;

	public HomePageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignInButton(){
		homepage_signInButton.click();
	}
}
