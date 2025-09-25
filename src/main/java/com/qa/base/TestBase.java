package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.Utilities.TestUtil;

public class TestBase {
	
	static WebDriver driver;
	static Properties prop;
	
	//First i will create a constructor
	public TestBase() throws IOException
	{
		prop = new Properties();
		//making a connecting between java code and config.properties->FIS
		FileInputStream fp = new FileInputStream("C:/Users/Venupriya/eclipse-workspace/MySeleniumcodeArtifactId/src/main/java/com/qa/config/config.properties");
		prop.load(fp);
		
	}
	
	public static void initialization()
	{
		String Browsername = prop.getProperty("browser");
		if(Browsername.equals("chrome"))
		
		{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Venupriya/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		
		
		}
		else if (Browsername.equals("FF"))
		{
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LONG_TIMEOUT));
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
	     driver.get(prop.getProperty("url"));

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
