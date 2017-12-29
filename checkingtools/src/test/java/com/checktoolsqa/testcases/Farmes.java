package com.checktoolsqa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class Farmes {
	WebDriver driver;
  @Test
  public void f() {
	  FirefoxProfile fp=new FirefoxProfile();
	  fp.setAssumeUntrustedCertificateIssuer(false);
	  driver=new FirefoxDriver(fp);
	  driver.get("https://timesofindia.indiatimes.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  int totalFame=driver.findElements(By.tagName("iframe")).size();
	  System.out.println("the toal no of frame is "+totalFame);
	 
	  
  }
}
