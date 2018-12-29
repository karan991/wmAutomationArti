package com.wmAutomationArti.testCases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wmAutomationArti.pages.launchLoginPage;
import com.wmAutomationArti.pages.leftSideMenuPage;
import com.wmAutomationArti.pages.HomeDashboardPage;


public class leftSideMenusPagePaneTestCases extends leftSideMenuPage {

	launchLoginPage launchLoginPage;
	leftSideMenuPage leftSideMenuPage;
	HomeDashboardPage HomeDashboardPage;
	
	public leftSideMenusPagePaneTestCases() {
		super();
	}
	


	@BeforeMethod

	public void Setup() {
		intialize();
		
	
	}
	
	@Test
	
	public void abc() {
		leftSideMenuHomePage();
	}
	
	
}
