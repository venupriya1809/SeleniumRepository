package com.qa.testcases;

//Design test cases in a systematic way
//html reports
//diff annotations
//priorities/sequence
//dependency
//grouping
//data provider
//testng-> open source, JAR FILES
//TDD-Test Driven Development
//TestNG doesn't have basics
//In testng if depends on methods say login is failed then other test cases which is depend on others will be skipped
//if i want to execute the test cases 10 times i can use invocation count.
//i	f i want to handle the exception in testng we will be using excepted exception
//we can also define groups by mentioning like groups= test, group =title so that in index.html we will be having separate groups tab if we click it will display teh results.

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.Utilities.ConfigReader;
import com.qa.base.BaseSingleton;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest{

	LoginPage loginPage;
	HomePage homePage;
	  
	
	
	@BeforeClass
	public void setup() {

		 BaseSingleton.getDriver();
		loginPage = new LoginPage(BaseSingleton.getDriver());

	}

	
	
	@Test(priority = 1)
	public void validateloginpagetitletest() {
		String TITLE = loginPage.validateloginpagetitle();
		Assert.assertEquals(TITLE, "#1 Free CRM Business Software - FreeCRM.com");
	}

	@Test(priority = 2)
	public void SignuppageTest() {
		loginPage.Signuppage();

	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(ConfigReader.getProperty("emailaddress"));

	}


}


	