package com.checktoolsqa.pageclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.checktoolsqa.commonclass.SelectFunctions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(features={"D:\\seleniumweb\\checkingtools\\src\\main\\java\\feature"},glue="steps")
public class Registration extends AbstractTestNGCucumberTests{

	public static WebDriver driver;
	public static WebElement element;
	public static List<WebElement> elements;
	 ExtentTest test;

	public Registration(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}

	public static WebElement registrationFormTitle(){
		element=driver.findElement(By.xpath("//h2[text()='Registration Form']"));
		return element;
	}
	
/*
 * This function is to fill the first name
 * 
 * */
	
	public static WebElement  firstName(){
		element=driver.findElement(By.id("name_3_firstname"));
		return element;
	}

	public void fillingFirstName(String firstName){
		firstName().sendKeys(firstName);
	}
	
	/*
	 * This function is to fill the last name
	 * 
	 * */
	
	public static WebElement  lastName(){
		element=driver.findElement(By.id("name_3_lastname"));
		return element;
	}
	
	public void fillingLastName(String lastName){
		lastName().sendKeys(lastName);
	}

	/*
	 * @param This function is to 
	 *  @param choose the martial status
	 * 
	 * */
	
	public static List<WebElement> maritalStatus(){
		elements=driver.findElements(By.xpath(".//*[@id='pie_register']/li[2]/div/div/input"));
		return elements;
	}
 
	public void chooseMartialStatus(String status){
	
		if(status.equals("Single")){
			maritalStatus().get(0).click();
		}
		else if(status.equals("Married")){
			maritalStatus().get(1).click();
		}
		else if(status.equals("Divorced")){
			maritalStatus().get(2).click();
		}
	}
	
	/*
	 * this is to choose the hobby
	 * */
	public static List<WebElement> hobby(){
		elements=driver.findElements(By.xpath(".//*[@id='pie_register']/li[3]/div/div[1]/input"));
		return elements;
	}
	
	public void chooseHobby(String hobby){
		
		if(hobby.equals("Dance")){
			hobby().get(0).click();
		}
		else if(hobby.equals("Reading")){
			hobby().get(1).click();
		}
		else if(hobby.equals("Cricket")){
			hobby().get(2).click();
		}
	}

	/*
	 * this function is to select country
	 * */
	public static WebElement countrySelectBox(){
		element=driver.findElement(By.id("dropdown_7"));
		return element;
	}

	public void selectingCountry(String countryName){
		SelectFunctions.selectingElementBytext(driver, countrySelectBox(), countryName);
	}
	
	/*
	 * this function is to select month
	 * */
	public static WebElement monthSelectBox(){
		element=driver.findElement(By.id("mm_date_8"));
		return element;
	}
	
	public void selectingMonth(String month){
		SelectFunctions.selectingElementBytext(driver, monthSelectBox(), month);
	}
	
	/*
	 * this function is to select
	 *  day
	 * */
	public static WebElement daySelectBox(){
		element=driver.findElement(By.id("dd_date_8"));
		return element;
	}
	
	public void selectingDay(String day){
		SelectFunctions.selectingElementBytext(driver, daySelectBox(), day);
	}
	
	/*
	 * this function is to selecting year
	 * */
	
	public static WebElement yearSelectBox(){
		element=driver.findElement(By.id("yy_date_8"));
		return element;
	}
	
	public void selectingYear(String year){
		SelectFunctions.selectingElementBytext(driver, yearSelectBox(), year);
	}
	/*
	 * this function is to fill up the phone no
	 * 
	 * */
	public static WebElement phoneNo(){
		element=driver.findElement(By.id("phone_9"));
		return element;
	}
	
	public void fillPhoneNo(String phoneNo){
		phoneNo().sendKeys(phoneNo);
	}
	
	/*
	 * This function is to fill up username
	 * 
	 * */
	
	public static WebElement userName(){
		element=driver.findElement(By.id("username"));
		return element;
	}
	
	public void fillUserName(String userName){
		userName().sendKeys(userName);
	}
	
	
	/*
	 * This function is to fill email
	 * 
	 * */
	
	public static WebElement eMail(){
		element=driver.findElement(By.xpath("//input[@id='email_1']"));
		return element;
	}
	
	public void fillEmail(String email){
		eMail().sendKeys(email);
	}
	
	/*
	 * this is for the password
	 * 
	 * */
	// pwd=password_2 and here i changed
	public static WebElement password(){
		element=driver.findElement(By.id("password_2"));
		return element;
	}
	
	public void fillPassWord(String password){
		password().sendKeys(password);
	}
	
	/*
	 * This function is to fill the confirm password
	 * 
	 * */
	
	public static WebElement confirmPassWord(){
		element=driver.findElement(By.id("confirm_password_password_2"));
		return element;
	}
	
	public void fillConfirmPassWord(String password){
		confirmPassWord().sendKeys(password);
	}
	/*
	 * this function is to fill the registration from
	 * 
	 * */
	
	
	public void submitRegistrationForm(){
		
		fillingFirstName("suriya");
		test.log(LogStatus.INFO, "filling up the first name");
		
		fillingLastName("kishoore");
		test.log(LogStatus.INFO, "filling up the  last name");
		chooseMartialStatus("Divorced");
		test.log(LogStatus.INFO, "choosing the martial status");
		chooseHobby("Dance");
		test.log(LogStatus.INFO, "choosing the hobby");
		selectingCountry("India");
		test.log(LogStatus.INFO, "selecting the country");
		selectingMonth("10");
		test.log(LogStatus.INFO, "selecting the month");
		selectingDay("19");
		test.log(LogStatus.INFO, "selecting the day");
		selectingYear("1991");
		test.log(LogStatus.INFO, "selecting year");
		fillPhoneNo("1387498310");
		test.log(LogStatus.INFO, "filling up the  phone no");
		fillUserName("suriya");
		test.log(LogStatus.INFO, "filling up the user name");
		fillEmail("elk@gmail.com");
		test.log(LogStatus.INFO, "filling up the  email");
		fillPassWord("reset123");
		test.log(LogStatus.INFO, "filling up the  password");
		fillConfirmPassWord("reset123");
		test.log(LogStatus.INFO, "confirming the password");
		
	}
}
