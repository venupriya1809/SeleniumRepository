package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class launchingbrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Venupriya/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println("FIRST NEW CHANGES AFTER PULL");
		System.out.println("FIRST NEW CHANGES AFTER PULL GITHUB LOCAL TO MASTERBRANCH VALIDATION");
		System.out.println("FIRST NEW CHANGES AFTER PULL GITHUB LOCAL TO MASTERBRANCH VALIDATION");
	}

}
