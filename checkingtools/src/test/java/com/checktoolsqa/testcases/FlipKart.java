package com.checktoolsqa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.checktoolsqa.baseclass.InvokeBrowser;
import com.checktoolsqa.commonclass.ActionFunctions;
import com.checktoolsqa.commonclass.SelectFunctions;
import com.checktoolsqa.commonclass.WaitForWebPage;
public class FlipKart {
	WebDriver driver;
	String xpath1="//select[@data-reactid='137'][option[@data-reactid='";
	String xpath2="']]";
	@Test
	public void Price() throws InterruptedException {

		driver= InvokeBrowser.openBrowser("firefox");
		driver.get("https://www.flipkart.com/");
		WaitForWebPage.puttingImplicityWait(driver, 10);
		driver.manage().window().maximize();
		checkForPopUp();
		ActionFunctions.mouseHover(driver, driver.findElement(By.xpath("//span[text()='Men']")));
		driver.findElement(By.xpath("//a[@title='Shirts']")).click();
		//finding all the data
		SelectFunctions.readAllTheDataFromSeleBox(driver, driver.findElement(By.xpath(".//*[@id='container']/div/div[1]/div/div[2]/div/div[1]/div/div/div[2]/section/div[4]/div[3]/select")));
		selectTheRange("1500");
	}


	public void selectTheRange(String range) throws InterruptedException{
		WebElement slideDot=driver.findElement(By.xpath("//div[@class='_3G9WVX _2N3EuE']"));
		WebElement bar=driver.findElement(By.xpath("//div[@class='_3QFE_k _3bwhLT']"));
		int y=bar.getSize().getHeight();
		System.out.println("y point "+y);
		int x=bar.getSize().getWidth();
		System.out.println("x point "+x);
		for(int i=0;i<5;i++){
			Actions act=new Actions(driver);
			act.dragAndDropBy(slideDot,-x/5,0).perform();
			Thread.sleep(3000);
		}
	}

	public void checkForPopUp(){
		try{
			WaitForWebPage.waitForVisibiltyOfElement(driver, driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")), 10);
			driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		}catch(NoSuchElementException t){
			System.out
			.println("Window pop up not found");
		}

	}

}
