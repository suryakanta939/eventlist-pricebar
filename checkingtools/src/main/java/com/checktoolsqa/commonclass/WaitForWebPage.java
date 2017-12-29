package com.checktoolsqa.commonclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForWebPage {
	
	public static void puttingImplicityWait(WebDriver driver,int timeInSec){
		
		driver.manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS);
	}
	
	
	public static void waitForVisibiltyOfElement(WebDriver driver,WebElement element,int timeInSec){
		
		WebDriverWait wait=new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public static void waitForElementClickable(WebDriver driver,WebElement element,int timeInSec){
		
		WebDriverWait wait=new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
