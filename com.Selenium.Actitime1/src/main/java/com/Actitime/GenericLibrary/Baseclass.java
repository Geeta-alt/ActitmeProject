package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Actitime.pom.HomePage;
import com.Actitime.pom.LoginPage;

public class Baseclass {

	public static WebDriver driver;
	Filelibrary f = new Filelibrary();
	
	@BeforeSuite
	public void dataBaseConnection() {
		Reporter.log("database connected successfully",true);
	}
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String URL = f.readdataFromPropertyFile("url");
		driver.get(URL);
		Reporter.log("browser launched successfully",true);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		String un = f.readdataFromPropertyFile("UserName");
		LoginPage lp = new LoginPage(driver);
		lp.getUntbx().sendKeys(un);
		String pw = f.readdataFromPropertyFile("password");
		lp.getPwtbx().sendKeys(pw);
		lp.getLgnbt().click();
		Reporter.log("logged in successfully",true);
	}
	
	@AfterMethod
	public void logout() {
		HomePage hp =new HomePage(driver);
		hp.getLogoutlnk().click();
		Reporter.log("logged out successfully");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
		Reporter.log("browser closed sucessfully",true);
	}
	
	@AfterSuite
	public void disconnectDataBaseConnection() {
		Reporter.log("database disconnected successfully",true);
	}

}
