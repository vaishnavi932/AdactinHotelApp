package com.adactin.baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass
{
	public static webdriver driver;
	
	public static WebDriver getDriver(String browsername) throws Exception 
	{
		try {
				if (browsername.equalsIgnoreCase("chrome")) 
				{
					System.setProperty("webdriver.chrome.driver", "D:\\JavaClass\\Selenium\\Driver\\chromedriver.exe");
					 driver=new ChromeDriver();
				}
				else if (browsername.equalsIgnoreCase("firefox")) 
				{
						System.setProperty("webdriver.gecko.driver",
								"D:\\eclipse workspace\\Selenium2\\driver\\geckodriver.exe");
						driver = new FirefoxDriver();
				}
			}

		catch (Exception e) 
		{
					throw new Exception("Invalid");

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
	
	public static void getUrl(String url) throws Exception 
	{
		try 
		{
			driver.get(url);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new Exception("url is not present");
		}

	}
	

	public static void setkey(WebElement element, String value) throws Exception 
	{
		waitforvisibilityofelment(element);
		try {
			if (elementisDisplayed(element) && elementisenabled(element)) {
				element.clear();
				element.sendKeys(value);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new Exception("values are not present");
		}

	}
	
	public static void getText(WebElement element) {
		try {
			System.out.println(element.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void click(WebElement element)
	{
		element.click();
	}
	


	public static void getAttribute(WebElement element) {
		try {
			String attribute = element.getAttribute("Value");
			System.out.println(attribute);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void waitforvisibilityofelment(WebElement element) {

		try {
			WebDriverWait wb = new WebDriverWait(driver, 30);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// is displayed

	public static boolean elementisDisplayed(WebElement element) 
	{
		boolean displayed = false;

		try {
			displayed = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return displayed;

	}

	// is enabled

	public static boolean elementisenabled(WebElement element) 
	{
		boolean enabled = false;

		try {
			enabled = element.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enabled;

	}

	// is selected

	public boolean elementisselected(WebElement element) {

		boolean selected = false;
		try {
			selected = element.isSelected();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selected;
	}

}
