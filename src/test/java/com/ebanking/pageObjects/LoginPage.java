package com.ebanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ebanking.testCases.BaseClass;
import com.ebanking.utilities.LoggerLoad;

public class LoginPage extends BaseClass {

	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="uid")WebElement txtUserName;
	@FindBy(name="password")WebElement txtPassword;
	@FindBy(name="btnLogin")WebElement loginBtn;
//	@FindBy(name="btnReset")WebElement resetBtn;
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a") 
	WebElement logoutBtn;
	
	public void sendUsername(String uname) {
		txtUserName.sendKeys(uname);
		//LoggerLoad.info("Inside Login Page class sendUsername");
	}
	public void sendPwd(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickLogin() {
		loginBtn.click();
	}
	public void clickLogout() {
		logoutBtn.click();
	}
}