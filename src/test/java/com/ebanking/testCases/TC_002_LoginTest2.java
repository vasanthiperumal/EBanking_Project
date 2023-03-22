package com.ebanking.testCases;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.LoginPage;
import com.ebanking.utilities.LoggerLoad;
import com.ebanking.utilities.XLUtils;

public class TC_002_LoginTest2 extends BaseClass
{
	
@Test(dataProvider="LoginData")
public void loginTest2(String user,String pwd) throws InterruptedException, IOException, AWTException
{
	driver.get(baseUrl);
	LoginPage lp=new LoginPage(driver);
	lp.sendUsername(user);
	LoggerLoad.info("user name entered");
	lp.sendPwd(pwd);
	LoggerLoad.info("password entered");
	lp.clickLogin();
	
	Thread.sleep(5000);
	
	if(isAlertPresent()==true) {
		captureScreen(driver,"loginTest2");
		LoggerLoad.info("isAlertPresent true");
		LoggerLoad.info("isAlertPresent true after screenshot");
		Assert.assertTrue(false);
		LoggerLoad.info("Login Failed");
		driver.switchTo().alert().accept();//close alert
		LoggerLoad.info("if isAlertPresent true after screenshot alert close");
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().defaultContent();
		
	}
	else
	{
		//captureScreen(driver,"loginTest2");
		Assert.assertTrue(true);
		LoggerLoad.info("Login Passed");
		lp.clickLogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		LoggerLoad.info("if else isAlertPresent true after screenshot alert close");
	}
}

public boolean isAlertPresent() throws InterruptedException 
{
	try {
		driver.switchTo().alert();
		//Thread.sleep(5000);
		return true;
	}
	catch(NoAlertPresentException e)
	{
		return false;
	}
}

@DataProvider(name="LoginData")
String[][] getData() throws IOException 
 {
	String path= System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\LoginData1.xlsx";
	System.out.println(path);
	int rownum=XLUtils.getRowCount(path, "Sheet1");
	System.out.println(rownum);
	int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
	System.out.println(colcount);
	String logindata[][]=new String[rownum][colcount];
	
	for(int i=1;i<=rownum;i++)
	{
		for(int j=0;j<colcount;j++)
		{
			logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
		}
	}
	
	return logindata;
 }

}
