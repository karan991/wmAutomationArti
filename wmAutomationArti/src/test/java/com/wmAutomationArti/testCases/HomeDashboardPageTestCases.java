package com.wmAutomationArti.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wmAutomationArti.pages.HomeDashboardPage;
import com.wmAutomationArti.pages.launchLoginPage;
import com.wmAutomationArti.testBase.testBase;

public class HomeDashboardPageTestCases extends HomeDashboardPage {
	
	launchLoginPage launchLoginPage;
	HomeDashboardPage HomeDashboardPage;
	
	
	
	@BeforeMethod
	
	public void setUp() {
		intialize();
		launchLoginPage = new launchLoginPage();
		HomeDashboardPage = launchLoginPage.login(prop.getProperty("user"),prop.getProperty("pass"));
		
		
	}
	
	@Test
	public void validateMT4UsersTileCountTest() {
		
		HomeDashboardPage.verifyDashboardTileLabelCountAndValue();
				
	}
	
	/*@Test
	
	public void validateDBvalueTest() {
		
		HomeDashboardPage.getDBMT4UserCount();
	}*/
	
	
	
	
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}
	
	
}


