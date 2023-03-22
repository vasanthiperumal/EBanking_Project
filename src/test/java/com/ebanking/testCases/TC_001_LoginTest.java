package com.ebanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.LoginPage;
import com.ebanking.utilities.LoggerLoad;



public class TC_001_LoginTest extends BaseClass{

	@Test
	public void loginTest() throws IOException
	{
		driver.get(baseUrl);
		LoginPage lp=new LoginPage(driver);
		lp.sendUsername(username);
		LoggerLoad.info("Username sent");
		lp.sendPwd(password);
		LoggerLoad.info("Password sent");
		lp.clickLogin();
		LoggerLoad.info("Login button clicked");
		//System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank ManagerHomePage")) {
			Assert.assertTrue(true);
			LoggerLoad.info("Test Passed");
		}
		else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			LoggerLoad.info("Test Failed");
		}
//		String title="Guru99 Bank Manager HomePage";
//		Assert.assertEquals(driver.getTitle(), title);
	}
}
