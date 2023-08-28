package com.iconnection.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//a[text()='Sign In']")
	private WebElement signinbtn;
	
	@FindBy(id="_com_liferay_login_web_portlet_LoginPortlet_login")
	private WebElement emailadd;
	
	@FindBy(id="_com_liferay_login_web_portlet_LoginPortlet_password")
	private WebElement password;
	
	@FindBy(xpath="(//button[@type=\"submit\"])[1]")
	private WebElement loginbtn;

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getSigninbtn() {
		return signinbtn;
	}

	public WebElement getEmailadd() {
		return emailadd;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//public Homepage icon() {
		//loginbtn.click();
		//return new Homepage(driver);
		
	//}

}
