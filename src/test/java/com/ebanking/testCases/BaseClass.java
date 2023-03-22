package com.ebanking.testCases;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.commons.io.FileUtils;

import com.ebanking.utilities.ConfigReader;
import com.ebanking.utilities.LoggerLoad;

public class BaseClass {
	
		ConfigReader configread=new ConfigReader();
		
		public String baseUrl=configread.getUrl();
		public String username=configread.getUsername();
		public String password=configread.getPassword();
		
		public static WebDriver driver;
		//public static Logger logger = LogManager.getLogger();
		
		@Parameters("browser")
		@BeforeClass
		public void init(String br)
		{
			LoggerLoad.info("Inside base class");
			
			if(br.equals("chrome"))
			{
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(ops);
			LoggerLoad.info("chrome browser");
			}
			else if(br.equals("firefox"))
			{
			driver=new FirefoxDriver();
			LoggerLoad.info("firefox browser");
			}
			else if(br.equals("edge"))
			{
			driver=new EdgeDriver();
			LoggerLoad.info("edge browser");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.get(baseUrl);
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}
		
		public void captureScreen(WebDriver driver,String tname) throws IOException{
			
			 try {
			LoggerLoad.info("Inside capturescreen");
			TakesScreenshot ts1=(TakesScreenshot) driver;
			Date d=new Date();
			String TimeStamp=d.toString().replace(":","_").replace(" ","_");
			LoggerLoad.info("Inside capturescreen TimeStamp"+TimeStamp);
			File source = ts1.getScreenshotAs(OutputType.FILE);
			LoggerLoad.info("Inside capturescreen file source"+source.getName());
			File target = new File(System.getProperty("user.dir")+ "/Screenshots/"+tname+"_"+TimeStamp+".png");
			LoggerLoad.info("Inside capturescreen file target"+target.getPath());
		  
			   LoggerLoad.info("Inside try Screenshot taken");
			   FileUtils.copyFile(source,target);
			   LoggerLoad.info("Screenshot taken");
			   LoggerLoad.info("Test Failed");
		   }
			catch(IOException e) {
				 LoggerLoad.info("Inside catch Screenshot taken");
				e.printStackTrace();
			}
		}
	}


