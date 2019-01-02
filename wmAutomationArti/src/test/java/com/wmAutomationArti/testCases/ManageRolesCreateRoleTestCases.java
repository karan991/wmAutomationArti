package com.wmAutomationArti.testCases;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.wmAutomationArti.pages.HomeDashboardPage;
import com.wmAutomationArti.pages.WhitelabelManageRolesTab;
import com.wmAutomationArti.pages.ManageRoleCreateRolePage;
import com.wmAutomationArti.pages.launchLoginPage;


//@Listeners({com.wmAutomationArti.util.testNGListener.class,com.wmAutomationArti.util.extentReportListenerRelevantCodes.class})
public class ManageRolesCreateRoleTestCases extends ManageRoleCreateRolePage {

	HomeDashboardPage HomeDashboardPage;
	launchLoginPage launchLoginPage;
	WhitelabelManageRolesTab WhitelabelManageRolesTab;
	ManageRoleCreateRolePage ManageRoleCreateRolePage;
	

	
	@BeforeMethod
	public void setup() {
	
		intialize();
		launchLoginPage = new launchLoginPage();
		HomeDashboardPage = launchLoginPage.login(prop.getProperty("user"), prop.getProperty("pass"));
		WhitelabelManageRolesTab = HomeDashboardPage.ManageRoles();
		ManageRoleCreateRolePage =  WhitelabelManageRolesTab.CreateRole();
	}
	
	/*@Test
	
	public void validateRolePageLabels() {
		
		ManageRoleCreateRolePage.validatePageLabels();
	}*/
	
	
	@Test(dataProvider="testdata")
	
	public void createRoleAndReset(String roleName, String slug, String description)
	{
		System.out.println(roleName+"--------------"+ slug+"--------------"+description);
		ManageRoleCreateRolePage.createRoleAndReset(roleName, slug, description);
		
	}
	
	@DataProvider(name="testdata")
	public  Object getCreateRoleTestDataN() {
		ManageRoleCreateRolePage getExcelData = new ManageRoleCreateRolePage();
		Object dataN =getExcelData.getCreateRoleTestData();
		return dataN;
	}
	
}
