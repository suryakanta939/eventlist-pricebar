
package com.checktoolsqa.commonclass;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionFunctions {

	 public static void mouseHover(WebDriver driver,WebElement element){
		 Actions act=new Actions(driver);
		 act.moveToElement(element).perform();
	 }
	 
	 public static void mouseHoverToElemntPoint(WebDriver driver,WebElement element){
		 Actions act=new Actions(driver);
		 int Xcord=element.getLocation().getX();
		 int Ycord=element.getLocation().getY();
		 element.getLocation().getY();
		 act.moveToElement(element, Xcord, Ycord).perform();
	 }
	 
	 public static void dragAndDropElement(WebDriver driver,WebElement secElement,WebElement dstElement){
		 Actions act=new Actions(driver);
		 act.clickAndHold(secElement).moveToElement(dstElement).release().perform();
	 }
	 
	 public static void rightClick(WebDriver driver,WebElement element){
		 Actions act=new Actions(driver);
		 act.contextClick(element).perform();
	 }
	 
	 public static void doubleClick(WebDriver driver,WebElement element){
		 Actions act=new Actions(driver);
		 act.doubleClick(element).perform();
	 }
	 
	 public static void openNewTab(WebDriver driver,WebElement element){
		 Actions act=new Actions(driver);
		 act.sendKeys(Keys.chord(Keys.CONTROL,"t")).perform();;
	 }
	 
	 public static void selectMultipleElement(WebDriver driver,WebElement element){
		 Actions act=new Actions(driver);
		 act.sendKeys(Keys.chord(Keys.CONTROL)).click(element).perform();
	 }
}
