package com.checktoolsqa.screenshotlib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenShot {
	
	public static String takeScreenShot(WebDriver driver,String fileName) throws IOException{
		File f=new File("ScreenShotFolder");
		File fs=new File(f,"");
		String path=fs.getAbsolutePath()+"//"+fileName+".png";
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
		File dstFile=new File(fs.getAbsolutePath()+"//"+fileName+".png");
		FileUtils.copyFile(srcFile, dstFile);
		return path;
	}

}
