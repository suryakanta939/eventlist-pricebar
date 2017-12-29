package com.checktoolsqa.testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.checktoolsqa.baseclass.InvokeBrowser;
import com.checktoolsqa.commonclass.WaitForWebPage;

public class SelectBoxChecking {
	WebDriver driver;
	String url="http://demo.guru99.com/selenium/webform/radio.html";
	String xpath1="//input[@type='checkbox' and @value='";
	String xpath2="']";

	@Test
	public void broke() throws InterruptedException {
		driver= InvokeBrowser.openBrowser("firefox");
		driver.get(url);
		WaitForWebPage.puttingImplicityWait(driver, 10);
		driver.manage().window().maximize();
		//		WebElement element = driver.findElement(By.xpath("//h2[text()='Online Demo']"));
		//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		//		Thread.sleep(500); 
		List<WebElement> elements=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i=0;i<1;i++){
			elements.get(i).click();
		}

	}

	@Test(dependsOnMethods="broke")
	public void cheking(){
		List<WebElement> elements=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i=0;i<elements.size();i++){
			boolean status=elements.get(i).isSelected();
			if(status==true){
				System.out.println("select box is selected");
			}else{
				elements.get(i).click();
			}
		}
	}	
}
