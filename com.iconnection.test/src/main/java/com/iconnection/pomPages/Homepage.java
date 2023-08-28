package com.iconnection.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	@FindBy(xpath="//span[contains(text(), ' Fund List ')]")
	private WebElement fundlist;
	
	@FindBy(xpath="//a[contains(text(), '1060 Capital Opportunity Fund')]")
	private WebElement capital;
	
	@FindBy(xpath="(//img[@class ='img-size-file'])[1]")
	private WebElement doc;
	
	@FindBy(xpath="(//img[@class ='img-size-file'])[3]")
	private WebElement pdf;
	
	@FindBy(xpath="(//img[@class ='img-size-file'])[4]")
	private WebElement excel;
	
	@FindBy(xpath="//span[@class=\"DataTables_sort_icon css_right ui-icon ui-icon-triangle-1-s\"]")
	private WebElement sorting;
	
	@FindBy(xpath="//a[contains(text(), 'Sign Out')]")
	private WebElement signout;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getSorting() {
		return sorting;
	}

	public WebElement getDoc() {
		return doc;
	}

	public WebElement getPdf() {
		return pdf;
	}

	public WebElement getExcel() {
		return excel;
	}

	

	public WebElement getFundlist() {
		return fundlist;
	}

	public WebElement getCapital() {
		return capital;
	}

	public WebElement getSignout() {
		return signout;
	}
	
	

}
