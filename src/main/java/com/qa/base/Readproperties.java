package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//C:\Users\Venupriya\Downloads\139.0.7258.66 chromedriver-win64\chromedriver-win64
//C:/Users/Venupriya/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe
public class Readproperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//how to read properties -first step is we have to create object for the properties class
		WebDriver driver = null;
		Properties prop = new Properties();
		//making a connecting between java code and config.properties->FIS
		FileInputStream fp = new FileInputStream("C:/Users/Venupriya/eclipse-workspace/MySeleniumcodeArtifactId/src/main/java/com/qa/config/config.properties");
		prop.load(fp);
		System.out.println(prop.getProperty("browser"));
		String Browsername = prop.getProperty("browser");
		if(Browsername.equals("chrome"))
		
		{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Venupriya/Downloads/139.0.7258.66 chromedriver-win64/chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		
		}
		else if (Browsername.equals("FF"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("url"));
		//driver.findElement(By.name("")).sendKeys(prop.getProperty("username"));
		//driver.findElement(By.name("")).sendKeys(prop.getProperty("password"));
	
		
		
		
		
	}

}
