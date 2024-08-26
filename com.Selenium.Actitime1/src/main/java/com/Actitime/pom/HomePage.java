package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement taskelmnt;
	
	@FindBy(xpath = "Time-Track")
	private WebElement timeelmnt;
	
	@FindBy(xpath = "//div[.='Reports']")
	private WebElement reportselmnt;
	
	@FindBy(xpath = "//div[.='Users']")
	private WebElement userelmnt;
	
	@FindBy(id = "logoutLink")
	private WebElement logoutlnk;
	
	public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	

	public WebElement getTaskelmnt() {
		return taskelmnt;
	}

	public WebElement getTimeelmnt() {
		return timeelmnt;
	}

	public WebElement getReportselmnt() {
		return reportselmnt;
	}

	public WebElement getUserelmnt() {
		return userelmnt;
	}

	public WebElement getLogoutlnk() {
		return logoutlnk;
	}
	

}
