package com.iconnection.genericLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
/**
 * 
 * @author PramodBanakar
 *
 */

public class WebdriverUtilies {
	
	public void dropdown(WebElement ele, String name) {
		Select s = new Select(ele);
		s.selectByVisibleText(name);
	}

}
