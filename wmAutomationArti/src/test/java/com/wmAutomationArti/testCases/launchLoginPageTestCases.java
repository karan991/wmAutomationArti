package com.wmAutomationArti.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wmAutomationArti.pages.launchLoginPage;

import com.wmAutomationArti.testBase.testBase;

public class launchLoginPageTestCases extends launchLoginPage {

	launchLoginPage loginPage;

	/*public launchLoginPageTestCases() {
		// TODO Auto-generated constructor stub
		super(); .
	}*/

	@BeforeMethod

	public void Setup() {
		intialize();
		loginPage = new launchLoginPage();

	}

	@Test(priority = 1)

	public void launchPageVerifyAllElementsTest() {
		loginPage.verifyAllElementsOnLaunchPage();

	}

	/*@Test(priority = 2)

	public void launchPageVerifyEmailTest() {
		loginPage.verifyEmailOnLaunchPage();
	}

	@Test(priority = 3)

	public void launchPageVerifyPasswordTest() {
		loginPage.verifyPaswordOnLaunchPage();
	}

	@Test(priority = 4)

	public void launchPageVerifyRememberMeLabelTest() {

		loginPage.verifyRememberMeLabelOnLaunchPage();

	}

	@Test(priority = 5)
	public void launchPageVerifyRememberMeTest() {
		loginPage.clickRememberMeOnLaunchPage();

	}*/

	@Test(priority = 6)

	public void loginWMTest() {
		loginPage.login(prop.getProperty("user"), prop.getProperty("pass"));

	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

	}
}
