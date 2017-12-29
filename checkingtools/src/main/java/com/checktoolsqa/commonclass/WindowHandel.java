package com.checktoolsqa.commonclass;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandel {

   public static void handelMultipleWindowByTitile(WebDriver driver,String windowtitlte){
	   
	   String pid=driver.getWindowHandle();
	   Set<String> windowsids=driver.getWindowHandles();
	   for(String windowID:windowsids){
		   System.out.println(windowID);
		   if(!windowID.equals(pid)){
			   driver.switchTo().window(windowID);
			   String title=driver.getTitle();
			   if(title.equals(windowtitlte))
			   {
				   driver.switchTo().window(windowID);
			   }
		   }
	   }
	  
   }
   
 public static void handelMultipleWIndowByWindowNo(WebDriver driver,int windowNoToSwitch){
	   
	   Set<String> windowsids=driver.getWindowHandles();
	   System.out.println("the total no of window present is "+windowsids.size());
	  if(windowsids.size()>1){
		  Iterator<String> itr=windowsids.iterator();
		  for(int i=1;i<=windowNoToSwitch;i++){
			  String id=itr.next();
			  if(i==windowNoToSwitch){
				  driver.switchTo().window(id);
			  }
		  }
	  }
   }
 
 public static void handelPopWindow(WebDriver driver){
	 String pid=driver.getWindowHandle();
	 Set<String> ids=driver.getWindowHandles();
	 if(ids.size()>1){
		 for(String id:ids){
			 if(!id.equals(pid)){
				 driver.switchTo().window(id).close();
			 }
		 }
	 }
	 else{
		 System.out.println("Thersr is no pop window");
	 }
 }   
	
}
