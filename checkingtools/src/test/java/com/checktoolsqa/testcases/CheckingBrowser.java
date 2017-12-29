package com.checktoolsqa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.checktoolsqa.baseclass.InvokeBrowser;
import com.checktoolsqa.commonclass.HandelEventListener;
import com.checktoolsqa.commonclass.WaitForWebPage;
import com.checktoolsqa.pageclass.Registration;
import com.checktoolsqa.reportlib.ExtentFactory;
import com.checktoolsqa.screenshotlib.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.CucumberOptions;


public class CheckingBrowser {
	WebDriver driver;
	ExtentTest test;
	ExtentReports report;
	Registration registration;
  @Parameters({"browser"})
  @Test
  public void check(String browser) throws MalformedURLException {

	  report=ExtentFactory.getInstance(); 
	  test=report.startTest("testing the qatools registraion");
//	  DesiredCapabilities caps = new DesiredCapabilities();
//	  // Set Platforms based on parameter received from testng.xml.
//	  caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);

	  // Set browser capability based on parameter received from testng.xml.
//	  if (browser.equalsIgnoreCase("Firefox"))
//	   caps = DesiredCapabilities.firefox();
//	  if (browser.equalsIgnoreCase("chrome"))
//	   caps = DesiredCapabilities.chrome();
//	  driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps);
	  	  
	  if(browser.equals("firefox")){
	  driver=InvokeBrowser.openBrowser(browser);
	  }else if(browser.equals("chrome")){
		  driver=InvokeBrowser.openBrowser(browser);
	  }
	  EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
	  HandelEventListener handel=new HandelEventListener();
	  driver=edriver.register(handel);
	  
	  test.log(LogStatus.INFO,"browser opened");
	  driver.get("http://demoqa.com/registration/");
	  test.log(LogStatus.INFO,"url entered");
	  driver.manage().window().maximize();
	  WaitForWebPage.puttingImplicityWait(driver, 10);
	  registration=new Registration(driver, test);
	  registration.submitRegistrationForm();
	  
  }
  @ AfterMethod
  public void executingAfterMethod(ITestResult result) throws IOException{
	  if(result.getStatus()==result.SUCCESS){
		 test.log(LogStatus.PASS, "testcase got pass");
	  }
	  else if (result.getStatus()==result.FAILURE) {
		  String path=ScreenShot.takeScreenShot(driver, result.getName());
		  test.log(LogStatus.FAIL,"test case got fail",test.addScreenCapture(path));
	  }
	  else if(result.getStatus()==result.SKIP){
		  test.log(LogStatus.SKIP,"test case got skip");
	  }
  }
  
  @AfterClass
  
  public void tearDown(){
	  driver.quit();
	  test.assignAuthor("suriya");
	  report.endTest(test);
	  report.flush();
  }
}
