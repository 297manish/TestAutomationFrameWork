package com.test.automation.POMFrameWork.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
	
	public WebDriver driver;
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public void selectBrowser(String browser){
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
			log.info("creating object of "+ browser);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			String log4jConfPath = "log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
		}
	}

	public void applyImplicitWait(int time){
		log.info("applying implicit wait");
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public void openUrl(String url){
		log.info("navigating to "+ url);
		driver.get(url);
	}
}
