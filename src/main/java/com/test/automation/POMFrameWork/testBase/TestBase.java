package com.test.automation.POMFrameWork.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import com.test.automation.POMFrameWork.excelReader.Excel_Reader;

public class TestBase {
	
	public static WebDriver driver;
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
	
	public String[][] getDataFromExcel(String sheetName){
		String path = System.getProperty("user.dir")+"/src/main/java/com/test/automation/POMFrameWork/data/TestData.xlsx";
		Excel_Reader excel = new Excel_Reader(path);
		String[][] data = excel.getData(sheetName);
		return data;
	}
	
	public void closeBroswser(){
		driver.quit();
	}
	public void getScreenShot(String name) throws IOException{
		try{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yy_hh_mm_ss");
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String repDir= new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/automation/POMFrameWork/screenshots/";
		File destFile = new File((repDir + name + "_" + formater.format(calendar.getTime())+".png"));
		FileUtils.copyFile(srcFile, destFile);
		Reporter.log("<a href ='"+destFile.getAbsolutePath()+"'> <img src ='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		}catch(Exception e){
			e.getMessage();
		}
	}
}






















