package com.qa.base;


import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.Utilities.ConfigReader;
import com.qa.Utilities.TestUtil;

public class BaseSingleton
{
	 private static WebDriver driver;
	 static Properties prop;
	 
	 //Singleton Class-> Only One object is created across the application. 
	 //Only one time it will be instantiated
	 //if i want to restricts creating multiple objects in other class i want to make constructor as private.If i want to create object i need a constructor 
	 //if i make the constructor as private i am unable to create objects.line no 25
	 //I will create an object inside the class and for storing that object i will use one reference variable.I will make that reference variable as Private since 
	 //No one should use that variable for object creation.i will make that as private and i will keep that as static since i want to create only one object Line no 15.
	 //if i want to assign that variable to a value i have to create one method and assignthe value to a variable i will create one method with public sttaic since
	 //only on that method we will call and return the same.line no 33 it will return class object so i will be using resturn type as Class actually in java it will be different here i wrote in selenium it is different
	 //pls check chatgpt for singleton class tamil pls check uniq academy.
	 
	 //here driver is a class-level static variable line no 15 and driver is a shared variable for the whole class.//It is static, so it belongs to the class, not to an instance.
//In Selenium, you never create an object of the WebDriver interface directly because it's an interface, not a concrete class.

//Instead, you always create an object of a class that implements WebDriver, like:line no 46//if (driver == null) {
	    //driver = new ChromeDriver(); // creates the instance only ONCE
	
	 
	private BaseSingleton() 
	{
	
	}
	
	public static WebDriver getDriver() {
        if (driver == null) 
        {
        	 driver = new ChromeDriver();
        	 // Set up browser driver from config
            String browser = ConfigReader.getProperty("browser");
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("chromeDriverPath"));
               
            }	
        
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LONG_TIMEOUT));
   	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
   	     driver.get(ConfigReader.getProperty("url"));
        }
        return driver;
    }
	 public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
