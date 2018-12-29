package com.wmAutomationArti.util;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wmAutomationArti.testBase.testBase;

public class JSExecutorUtils {



	public static void highLighterMethod(WebDriver driver, WebElement... webElements) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement Element : webElements) {
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
					Element);

		}
	}

	public static void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) testBase.driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element " + e.getStackTrace());
		}

	}

	public static void pageScrollElementvisible(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
