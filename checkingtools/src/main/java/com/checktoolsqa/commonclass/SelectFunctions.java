package com.checktoolsqa.commonclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectFunctions {
	
	public static void selectingElementBytext(WebDriver driver,WebElement element,String text){
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public static void selectingElementByIndex(WebDriver driver,WebElement element,int index){
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public static void selectingElementByValue(WebDriver driver,WebElement element,String value){
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public static void readAllTheDataFromSeleBox(WebDriver driver,WebElement element){
		Select sel=new Select(element);
		List<WebElement> elements=sel.getOptions();
		for(int i=0;i<elements.size();i++){
			String name=elements.get(i).getAttribute("value");
			System.out.println(name);
		}
	}
	
	public static void verifyElement(WebDriver driver,WebElement element,String Desiredtext){
		 
		Select sel=new Select(element);
		List<WebElement> elements=sel.getOptions();
		for(int i=0;i<elements.size();i++){
			String name=elements.get(i).getAttribute("value");
			if(name.equals(Desiredtext)){
				System.out.println("element match found");
			}else{
				System.out.println("no match");
			}
		}
		
	}

}
