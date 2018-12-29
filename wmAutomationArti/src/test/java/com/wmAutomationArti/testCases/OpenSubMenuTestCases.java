package com.wmAutomationArti.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.wmAutomationArti.pages.HomeDashboardPage;
import com.wmAutomationArti.pages.OpenSubMenuPage;
//import com.wmAutomationArti.pages.WhitelabelManageRolesTab;
import com.wmAutomationArti.pages.launchLoginPage;

public class OpenSubMenuTestCases extends OpenSubMenuPage {

	//HomeDashboardPage HomeDashboardPage;
	launchLoginPage launchLoginPage;
	OpenSubMenuPage OpenSubMenuPage;
	;
	
	OpenSubMenuTestCases(){
		super();
	}

	@BeforeMethod
	public void setup() {
	
		intialize();
		launchLoginPage = new launchLoginPage();
		//OpenSubMenuPage = launchLoginPage.loginToMenu(prop.getProperty("user"), prop.getProperty("pass"));
		System.out.println("This IS OPENSUBMENU DRIVER"+ OpenSubMenuPage);
		OpenSubMenuPage.JustPassParentandSubMenu(OpenSubMenuPage.WhitelableTab,
				OpenSubMenuPage.WhitelableTabExpandManageRoles);
		
	}
	@Test
	public void getPageurl() {
		
		
		OpenSubMenuPage.abcd();
		
		
		
	}
	

	
	
}
