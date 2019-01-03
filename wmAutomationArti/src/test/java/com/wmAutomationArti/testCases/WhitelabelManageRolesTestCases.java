package com.wmAutomationArti.testCases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wmAutomationArti.pages.HomeDashboardPage;
import com.wmAutomationArti.pages.WhitelabelManageRolesTab;
import com.wmAutomationArti.pages.launchLoginPage;



public class WhitelabelManageRolesTestCases extends WhitelabelManageRolesTab{
	
	HomeDashboardPage HomeDashboardPage;
	launchLoginPage launchLoginPage;
	WhitelabelManageRolesTab WhitelabelManageRolesTab;
	

	
	@BeforeMethod
	public void setup() {
	
		intialize();
		launchLoginPage = new launchLoginPage();
		HomeDashboardPage = launchLoginPage.login(prop.getProperty("user"), prop.getProperty("pass"));
		WhitelabelManageRolesTab = HomeDashboardPage.ManageRoles();
		
	
		
	}
	@Test
	public void ValiddateManageRolesPageUIElements() {
		
		WhitelabelManageRolesTab.validatePageLabelAndTable();;
		
	}
}

