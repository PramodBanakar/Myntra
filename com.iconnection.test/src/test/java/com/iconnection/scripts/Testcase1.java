package com.iconnection.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iconnection.genericLib.AutoConstant;
import com.iconnection.genericLib.BaseClass;
import com.iconnection.pomPages.Homepage;
import com.iconnection.pomPages.LoginPage;

public class Testcase1 extends BaseClass {
	
	@Test
	public void testcase1() throws FileNotFoundException, IOException, InterruptedException {
		test=reports.createTest("testcase1");
		
		Thread.sleep(3000);
		LoginPage l=new LoginPage(driver);
		l.getSigninbtn().click();
		Thread.sleep(2000);
		l.getEmailadd().clear();
		
		l.getEmailadd().sendKeys(fu.getExcelFile("Sheet1", 1, 0));
		Thread.sleep(2000);
		l.getPassword().sendKeys(fu.getExcelFile("Sheet1", 1, 1));
		Thread.sleep(2000);
		//Homepage hp = l.icon();
		l.getLoginbtn().click();
		Thread.sleep(2000);
		Homepage hp=new Homepage(driver);
		hp.getFundlist().click();
		Thread.sleep(2000);
		hp.getFundlist().click();
		Thread.sleep(3000);
		//hp.getSorting().click();
		//Thread.sleep(5000);
		//hp.getSorting().click();
		//Thread.sleep(5000);
		hp.getDoc().click();
		Thread.sleep(3000);
		//hp.getPdf().click();
		Thread.sleep(3000);
		hp.getExcel().click();
		Thread.sleep(5000);
		hp.getCapital().click();
		Thread.sleep(5000);
		hp.getSignout().click();
		
		//Assert.assertEquals(driver.getTitle() ,fu.getPropertyFile("title"));
	
	}

}
