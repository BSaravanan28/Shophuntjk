package com.shophunt.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	
	@Override	
	public void onTestSuccess(ITestResult result) {
		
		String testname=result.getMethod().getMethodName();
		System.out.println(testname+" Listen");
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		File des=new File("./screenshot/"+testname+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testname=result.getMethod().getMethodName();
		System.out.println(testname+" Listen");
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		File des=new File("./screenshot/"+testname+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	/* @Override
	public void onTestStart(ITestResult result) {
		
		ITestListener.super.onTestStart(result);
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		
		ITestListener.super.onFinish(context);
	} */

}
