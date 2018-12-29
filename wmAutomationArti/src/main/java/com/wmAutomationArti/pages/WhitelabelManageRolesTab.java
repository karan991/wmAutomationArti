package com.wmAutomationArti.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.wmAutomationArti.testBase.testBase;
import com.wmAutomationArti.util.JSExecutorUtils;
import com.wmAutomationArti.util.testUtil;

public class WhitelabelManageRolesTab extends testBase {

	@FindBy(xpath = "//h2[@class]")
	WebElement RolesLabel;

	@FindBy(xpath = "//a[@href='#/whitelabel/createrole']")
	WebElement createRoleButton;

	@FindBy(xpath = "//span[contains(text(),'S.NO')]")
	WebElement columnHeadingSNO;

	@FindBy(xpath = "//span[contains(text(),'NAME')]")
	WebElement columnHeadingNAME;

	@FindBy(xpath = "//span[contains(text(),'DESCRIPTION')]")
	WebElement columnHeadingDESCRIPTION;

	@FindBy(xpath = "//span[contains(text(),'ACTIONS')]")
	WebElement columnHeadingACTIONS;

	@FindBy(xpath = "//tbody/tr")
	List<WebElement> No_Of_Roles;

	@FindBy(xpath = "//tbody/tr/td")
	List<WebElement> No_of_columns;

	public WhitelabelManageRolesTab() {
		PageFactory.initElements(driver, this);
	}

	public void validatePageLabelAndTable() {

		testUtil.fluentwaitr.until(ExpectedConditions.visibilityOf(RolesLabel));
		JSExecutorUtils.highLighterMethod(driver, RolesLabel, createRoleButton, columnHeadingSNO, columnHeadingNAME,
				columnHeadingDESCRIPTION, columnHeadingACTIONS);

		int colInRow = No_of_columns.size() / No_Of_Roles.size(); // Its to fetch number columns in a row

		// Iterator<WebElement> itrRow = No_Of_Roles.iterator(); Tired Iterator but
		// didn't work out I am not able to implement it properly

		// Iterator<WebElement> itrCol = No_of_columns.iterator(); Tired Iterator but
		// didn't work out I am not able to implement it properly

		int i, j;
		i = j = 1;

		while (i <= No_Of_Roles.size()) {
			System.out.println("LOOP FOR ROW " + i);
			while (j <= colInRow) {

				String tableColumns = "//tbody/tr[" + i + "]/td[" + j + "]";
				WebElement col = driver.findElement(By.xpath(tableColumns));
				JSExecutorUtils.highLighterMethod(driver, col);
				j++;
			}

			i++;
			j = j - colInRow;
		}
	}
	
	
	
	public ManageRoleCreateRolePage CreateRole() {

		createRoleButton.click();

		return new ManageRoleCreateRolePage();
	}

}
