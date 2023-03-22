package com.ebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
Properties prop;

public ConfigReader()
{
	File src=new File("./src/test/resources/config/config.properties");
	
	try {
		
		FileInputStream fis=new FileInputStream(src);
		prop= new Properties();
		prop.load(fis);
	}
	catch(Exception e) {
		System.out.println("Exception is "+e.getMessage());
	}
	
}

 public String getUrl()
 {
	 String url=prop.getProperty("baseUrl");
	 return url;
 }
 public String getUsername()
 {
 	String uname=prop.getProperty("username");
 	return uname;
 }
public String getPassword()
{
	String pwd=prop.getProperty("password");
	return pwd;
}

}
