package com.wmAutomationArti.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;

import com.wmAutomationArti.testBase.testBase;
import com.wmAutomationArti.util.JSExecutorUtils;
import com.wmAutomationArti.util.fetchExcelData;
import com.wmAutomationArti.util.getExcelData;
import com.wmAutomationArti.util.testUtil;

public class ManageRoleCreateRolePage extends testBase {

	@FindBy(xpath = "//h2[@class='ng-binding']")
	public WebElement createRoleLabel;

	@FindBy(xpath = "//input[@id='name']")
	public WebElement RoleName;

	@FindBy(xpath = "//input[@name='slug']")
	public WebElement Slug;

	@FindBy(xpath = "//textarea[@name='description']")
	public WebElement Description;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement SubmitButton;

	@FindBy(xpath = "//button[@class='btn btn-danger btn-sm m-t-10 waves-effect ng-binding']")
	public WebElement ResetButton;

	@FindBy(xpath = "//div[@ng-show='roleForm.name.$dirty && roleForm.name.$error.minlength']")
	public WebElement roleNameValidationForAtleast3char;

	@FindBy(xpath = "//div[@ng-show='load']")
	public WebElement roleNameValidationForCheckingAvailableRoleName;

	public getExcelData getExcelData = new getExcelData("CreateRoleTestData");

	public ManageRoleCreateRolePage() {
		PageFactory.initElements(driver, this);
	}

	public void validatePageLabels() {

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		testUtil.fluentwaitr.until(ExpectedConditions.visibilityOf(ResetButton));
		JSExecutorUtils.highLighterMethod(driver, createRoleLabel, RoleName, Slug, Description, SubmitButton,
				ResetButton);

	}

	public void createRoleAndReset(String roleName, String slug, String description) {

		RoleName.sendKeys("ad");
		JSExecutorUtils.highLighterMethod(driver, roleNameValidationForAtleast3char);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		RoleName.clear();
		RoleName.sendKeys("asdlasdlaksdlkaldkalsdalsdaklsdksaldkal");
		JSExecutorUtils.highLighterMethod(driver, roleNameValidationForCheckingAvailableRoleName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RoleName.clear();

		RoleName.sendKeys(roleName);
		Slug.sendKeys(slug);
		Description.sendKeys(description);

		ResetButton.click();

		RoleName.sendKeys(roleName);
		Slug.sendKeys(slug);
		Description.sendKeys(description);

		SubmitButton.click();
		fetchExcelData fexceldata = new fetchExcelData();
				fexceldata.readDataFromExcel();
	}

	//@DataProvider(name="testdata")
	public  Object getCreateRoleTestData() {

		Object data[][] = new Object[getExcelData.getRowCount() - 1][getExcelData.getColumnCountInRow()];

		for (int i = 1; i < getExcelData.getRowCount(); i++) {
			for (int j = 0; j < getExcelData.getColumnCountInRow(); j++) {

				System.out.println("CELL VALUE :  " + getExcelData.getCellDataString(i, j));
				data[i - 1][j] = getExcelData.getCellDataString(i, j);
			}
		}
		return data;
	}

}
