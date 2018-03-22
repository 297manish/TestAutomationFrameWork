package com.test.automation.POMFrameWork.loginPageTest;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.POMFrameWork.testBase.TestBase;

public class LoginWithMultipleUsers extends TestBase{
	
	@DataProvider(name="login")
	public String[][] getTestData(){
		String[][] loginData = getDataFromExcel("Test");
		return loginData;
	}
	
	@Test(dataProvider="login")
	public void testa(String a, String b, String c){
		if(c.equalsIgnoreCase("n")){
			throw new SkipException("skiping test");
		}
		
		System.out.println(a);
		System.out.println(b);
		
	}

}
