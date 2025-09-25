package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
 private WebDriver driver;

 // defining the Page factory

 @FindBy(xpath = "//a[.//span[text()=' sign up']]")
 WebElement signup;
 
 @FindBy(id = "email-input")
 WebElement EMAILADDRESS;
 
 @FindBy(xpath = "//span[@id='recaptcha-anchor']")
 WebElement Anchortag;
 
 @FindBy(xpath = "//button[@id='sign-in-btn']")
 WebElement Signin;
 

 //Now we need to initialize the WebElements 
 
 public LoginPage(WebDriver driver)
 {
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	 
 }
 //actions-> different scenarios
 public String validateloginpagetitle()
 {
	 return driver.getTitle();
 }
 
 public void Signuppage()
 {
	 signup.click();
	 }
 public HomePage login(String email)
 {
	 EMAILADDRESS.sendKeys(email);
	 Signin.click();
	 
	 return new HomePage();
	 
 }
}

