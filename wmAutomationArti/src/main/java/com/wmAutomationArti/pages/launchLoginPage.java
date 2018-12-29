package com.wmAutomationArti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.wmAutomationArti.testBase.testBase;
import com.wmAutomationArti.util.JSExecutorUtils;
import com.wmAutomationArti.util.testUtil;

public class launchLoginPage extends testBase {

		
	@FindBy(xpath = "//input[@id='email']")
	WebElement loginEmailInput;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement loginPasswordInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginSubmitButton;

	@FindBy(xpath = "//img[@class='text-center']")
	WebElement brandLogo;

	@FindBy(xpath = "//div[@class='checkbox']/label")
	WebElement rememberMeLabel;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement rememberMeCheckbox;

	@FindBy(xpath = "")
	WebElement version;

	public launchLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyAllElementsOnLaunchPage(){
		
	//public void verifyBrandOnLaunchPage() {

		// BRAND LOGO IMAGE
		
		testUtil.softAsertion.assertEquals("http://devwmfront-deer.c64f.com/img/logo/logo.png", brandLogo.getAttribute("src"));
		testUtil.fluentwaitr.until(ExpectedConditions.visibilityOf(brandLogo));
		testUtil.softAsertion.assertTrue(brandLogo.isDisplayed(),"brandLogo Not displayed");
		JSExecutorUtils.highLighterMethod(driver, brandLogo);
		//testUtil.softAsertion.assertAll();
	//}

	//public void verifyEmailOnLaunchPage() {

		// EMAIL INPUT FIELD
		testUtil.fluentwaitr.until(ExpectedConditions.visibilityOf(loginEmailInput));
		testUtil.softAsertion.assertEquals("Email", loginEmailInput.getAttribute("placeholder"));
		testUtil.softAsertion.assertTrue(loginEmailInput.isEnabled(), "loginEmailInput Not Enabled");
		testUtil.softAsertion.assertTrue(loginEmailInput.isDisplayed(),"loginEmailInput Not displayed");
		JSExecutorUtils.highLighterMethod(driver, loginEmailInput);
		//testUtil.softAsertion.assertAll();
	//}

	//public void verifyPaswordOnLaunchPage() {

		// PASWORD INPUT FIELD
		testUtil.fluentwaitr.until(ExpectedConditions.visibilityOf(loginPasswordInput));
		testUtil.softAsertion.assertEquals("Password", loginPasswordInput.getAttribute("placeholder"));
		testUtil.softAsertion.assertTrue(loginPasswordInput.isDisplayed(),"loginPasswordInput Not displayed");
		testUtil.softAsertion.assertTrue(loginPasswordInput.isEnabled(),"loginPasswordInput Not Enabled");
		JSExecutorUtils.highLighterMethod(driver, loginPasswordInput);
		//testUtil.softAsertion.assertAll();
	//}

	//public void verifySubmitOnLaunchPage() {

		// SUBMIT BUTTON
		testUtil.fluentwaitr.until(ExpectedConditions.visibilityOf(loginSubmitButton));
		testUtil.softAsertion.assertTrue(loginSubmitButton.isDisplayed(), "loginSubmitButton Not displayed");
		testUtil.softAsertion.assertTrue(loginSubmitButton.isEnabled(),"loginSubmitButton Not Enabled");
		JSExecutorUtils.highLighterMethod(driver, loginSubmitButton);
		//testUtil.softAsertion.assertAll();
	//}

	//public void verifyRememberMeLabelOnLaunchPage() {

		// REMEMBER ME LABEL

		// testUtil.softAsertion.assertEquals(" Remember me", rememberMeLabel.getText());
		testUtil.fluentwaitr.until(ExpectedConditions.visibilityOf(rememberMeLabel));
		testUtil.softAsertion.assertTrue(rememberMeLabel.isDisplayed(),"rememberMeLabel Not displayed");
		testUtil.softAsertion.assertTrue(rememberMeLabel.isEnabled(),"rememberMeLabel Not Enabled");
		JSExecutorUtils.highLighterMethod(driver, rememberMeLabel);
		//testUtil.softAsertion.assertAll();
	//}

	//public void clickRememberMeOnLaunchPage() {

		// REMEMBER ME CHECKBOX
		/*testUtil.fluentwaitr.until(ExpectedConditions.visibilityOf(rememberMeCheckbox));
		testUtil.softAsertion.assertTrue(rememberMeCheckbox.isDisplayed(),"rememberMeCheckbox Not Displayed");
		testUtil.softAsertion.assertFalse(rememberMeCheckbox.isSelected());
		testUtil.softAsertion.assertTrue(rememberMeCheckbox.isEnabled()," rememberMeCheckbox Not Enabled");
		JSExecutorUtils.highLighterMethod(driver, rememberMeCheckbox);
		rememberMeCheckbox.click();
		testUtil.softAsertion.assertAll();*/

	}

	public HomeDashboardPage login(String un, String pass) {
		loginEmailInput.sendKeys(un);
		JSExecutorUtils.highLighterMethod(driver, loginEmailInput);
		loginPasswordInput.sendKeys(pass);
		JSExecutorUtils.highLighterMethod(driver, loginPasswordInput);
		loginSubmitButton.click();
		JSExecutorUtils.highLighterMethod(driver, loginSubmitButton);
		
		return new HomeDashboardPage();
		
	}
	

	/*public OpenSubMenuPage loginToMenu(String un, String pass) {
		loginEmailInput.sendKeys(un);
		JSExecutorUtils.highLighterMethod(driver, loginEmailInput);
		loginPasswordInput.sendKeys(pass);
		JSExecutorUtils.highLighterMethod(driver, loginPasswordInput);
		loginSubmitButton.click();
		JSExecutorUtils.highLighterMethod(driver, loginSubmitButton);
		
		return new OpenSubMenuPage();
		
	}*/
	

}