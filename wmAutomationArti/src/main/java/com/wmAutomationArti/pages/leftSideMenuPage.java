package com.wmAutomationArti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wmAutomationArti.testBase.testBase;
import com.wmAutomationArti.util.JSExecutorUtils;

public class leftSideMenuPage extends testBase {

	@FindBy(xpath="//ul[@class='main-menu']//a[@data-ui-sref ='home']")WebElement HomeTab;
	// This xpath can also be used for home tab //ul[@class='main-menu']/li[@data-ui-sref-active='active']/a[contains(text(),home)]
	
	
	
	
	
	public leftSideMenuPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void leftSideMenuHomePage(){
		JSExecutorUtils.highLighterMethod(driver, HomeTab);
		System.out.println(HomeTab.getText());
	}
	
	
}
