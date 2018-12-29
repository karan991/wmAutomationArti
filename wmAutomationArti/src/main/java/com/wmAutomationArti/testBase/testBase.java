package com.wmAutomationArti.testBase;

import java.beans.EventHandler;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.wmAutomationArti.util.testUtil;
import com.wmAutomationArti.util.webDriverEventListener;

public class testBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String currentDirectory = System.getProperty("user.dir");
	public static EventFiringWebDriver e_driver;
	public static webDriverEventListener eventListner;
	

	// public static Wait thisIsFluentWaitObj;
	public testBase()

	{
		try {
			prop = new Properties();

			String PropertiesFilePath = currentDirectory
					+ "\\src\\main\\java\\com\\wmAutomationArti\\config\\config.properties";
			System.out.println("PROPERTIES FILE PATH ---- " + PropertiesFilePath);
			FileInputStream fis = new FileInputStream(PropertiesFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Saale -- File kahan hai");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Saale -- File mein kuch garbadh hai");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void intialize() {

		String browserName = prop.getProperty("browserName");
		if (browserName.equals("chrome")) {

			String ChromeDriverPath = currentDirectory
					+ "\\src\\main\\resources\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe";

			System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
			driver = new ChromeDriver();

		} else if (browserName.equals("FF")) {
			System.setProperty("webDdriver.gecko.driver", currentDirectory
					+ "src\\main\\resources\\BrowserDrivers\\geckodriver-v0.22.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		 eventListner= new webDriverEventListener();
		 e_driver.register(eventListner);
		 driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(testUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// return driver;
		

	}

	
}
