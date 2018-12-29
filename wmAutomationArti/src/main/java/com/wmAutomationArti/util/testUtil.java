package com.wmAutomationArti.util;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.wmAutomationArti.testBase.testBase;


public class testUtil  {

	public static long PAGE_LOAD_TIMEOUT = 20;

	// Its okay if you use "static public" or "public static". it doesn't make any
	// difference.

	public static long IMPLICIT_WAIT = 10;

	public static SoftAssert softAsertion = new SoftAssert();

	public static WebDriverWait explicitWait = new WebDriverWait(testBase.driver, 10);
	
	public static Wait<WebDriver> fluentwaitr = new FluentWait<WebDriver>(testBase.driver)
			.withTimeout(IMPLICIT_WAIT, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class);
	
	public static void takeScreenShot() {
		TakesScreenshot screenshot= ((TakesScreenshot)testBase.driver) ;
	File srcFile = screenshot .getScreenshotAs(OutputType.FILE);
	File destnationFile =  new File(System.getProperty("user.dir")+"\\test-output\\ScreenShots\\"+System.currentTimeMillis()+".png");

    try {
		FileUtils.copyFile(srcFile, destnationFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}

