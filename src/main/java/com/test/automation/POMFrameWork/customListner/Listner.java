package com.test.automation.POMFrameWork.customListner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.automation.POMFrameWork.testBase.TestBase;

public class Listner extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yy_hh_mm_ss");
		String methodName = result.getName();
		System.out.println(methodName);
		if(!result.isSuccess()){			
			try{
				File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String repDir= new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/automation/POMFrameWork/screenshotsOnFailure/";
				File destFile = new File((repDir + methodName + "_" + formater.format(calendar.getTime())+".png"));
				FileUtils.copyFile(srcFile, destFile);
				Reporter.log("<a href ='"+destFile.getAbsolutePath()+"'> <img src ='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			}catch(Exception e){
				e.getMessage();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println("Test Case Execution Started");

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
