package com.checktoolsqa.reportlib;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance(){
		ExtentReports report;
		File f=new File("Reports");
		File fs=new File(f,"");
		report=new ExtentReports(fs.getAbsolutePath()+"//tools.html", false);
		return report;
		
	}
}
