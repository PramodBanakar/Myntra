package com.iconnection.genericLib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author PramodBanakar
 *
 */
public class BaseClass {
	public WebDriver driver;
	public ExtentHtmlReporter htmlreport;
	public static ExtentReports reports;
	public static ExtentTest test;
	public FileUtilities fu=new FileUtilities();
	
	@BeforeSuite
	public void configBS() {
		/**
		 * It is used to generate report.
		 */
		htmlreport = new ExtentHtmlReporter(AutoConstant.reportpath);
		htmlreport.config().setDocumentTitle("iconnection Report");
		htmlreport.config().setTheme(Theme.STANDARD);
		reports = new ExtentReports();
		reports.attachReporter(htmlreport);
		
		}
	@BeforeMethod
	public void openApp() throws FileNotFoundException, IOException {
		/**
		 * it is used to open the browser and enter the URL
		 */
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fu.getPropertyFile("url"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.findElement(By.id("details-button")).click();
		//driver.findElement(By.id("proceed-link")).click();
		
	}
	
	@AfterMethod
	public void closeApp(ITestResult res) throws IOException {
		/**
		 * It is used to close the application
		 */
		int result = res.getStatus();
		if(result==ITestResult.FAILURE) {
				Photo p=new Photo();
				p.screenshot(driver, res.getName());
			test.log(Status.FAIL,res.getName() +"Test case failed");
			test.log(Status.FAIL,res.getThrowable()+ "Test case failed exception");
			}
		else if(result==ITestResult.SUCCESS){
			test.log(Status.PASS,res.getName()+"Test case Passed");
			}
		else if(result==ITestResult.SKIP) {
			test.log(Status.SKIP,res.getName()+"Test case skipped");
		}
		//driver.quit();
	}
	
	@AfterSuite
	public void configAS() {
		/**
		 * it is used to clear the report
		 */
		htmlreport.flush();
		reports.flush();
	}

}
