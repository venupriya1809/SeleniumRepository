package com.qa.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.base.BaseSingleton;

public class BaseTestScreenshot {
	//proteted-Within the same package and in child (sub) classes
	//protected allows access in:The base class

//Any subclasses, even in different packages


    protected WebDriver driver;
//It initializes your WebDriver instance (driver) by calling a static method from the BaseSingleton class, which follows the Singleton design pattern.
    @BeforeMethod
    public void setUp() {
        driver = BaseSingleton.getDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getName());
        }
        
    }

    public void takeScreenshot(String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String filePath = "./screenshots/" + testName + ".png";
        try {
            FileUtils.copyFile(srcFile, new File(filePath));
            System.out.println("Screenshot saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	


