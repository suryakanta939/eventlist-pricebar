package com.checktoolsqa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RandomTest {
	WebDriver driver;
	String xpathCheckbox1=".//*[@id='table01']/tbody/tr[";
	String xpathCheckbox2="]/td[1]/input";
	String xpathtrack1=".//*[@id='table01']/tbody/tr[";
	String xpathtrack2="]/td[4]";
  @Test
  public void f() throws InterruptedException {
	  driver=new FirefoxDriver();
	  driver.get("https://qavalidation.com/demo/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  WebElement element = driver.findElement(By.xpath("//a[text()='Testing basics!']"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	  Thread.sleep(500);
	  check("TFS");
	  
  }
  public  void check(String name){
	  for(int i=1;i<4;i++){
			 String issutrackerName=driver.findElement(By.xpath(xpathtrack1+i+xpathtrack2)).getText();
			 if(issutrackerName.equals(name)){
				 driver.findElement(By.xpath(xpathCheckbox1+i+xpathCheckbox2)).click();
			 }
		  }
  }
}
