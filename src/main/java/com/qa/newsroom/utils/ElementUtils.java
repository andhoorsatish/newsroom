package com.qa.newsroom.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	private WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;				
	}
	
	public By getLocator(String value) {
		return By.id(value);
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	

	public WebElement getElement(By locator) {		
		WebElement element = null;		
		try {
			waitUntilElementPresent(locator, 30);
			element = driver.findElement(locator);
		}
		catch(Exception e) {
			System.out.println("Some exception occured while locating this element: " +locator);
			System.out.println(e.getMessage());
		}
		return element;		
	}
	
	public void waitUntilElementPresent(By locator, int timeout) { //explicit wait
		
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));		
	}
	
	public void doClick(By locator, int timeout) {
		try{
			waitUntilElementPresent(locator, timeout);
			getElement(locator).click();
		}catch(Exception e) {
			System.out.println("Some exception occured while locating clicking on this element: " +locator);
			System.out.println(e.getMessage());

		}
		
	}
	
	public void doSendKeys(By locator,int timeout, String... keysToSend) { //this will accept 1 or multiple values
		
		try{
			waitUntilElementPresent(locator, timeout);
			getElement(locator).sendKeys(keysToSend);
		}catch(Exception e) {
			System.out.println("Some exception occured while trying to enter characters in this element: " +locator);
			System.out.println(e.getMessage());

		}
	}
	
	public String waitForTitlePresent(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.getTitle();
	}
	
	public String waitForTitlePresent(String titleValue, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut, intervalTime);
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.getTitle();
	}
	
	public int getElementsSize(By locator) {
		
		return driver.findElements(locator).size();
		
	}
	
	public String getAttributeValue(By locator, String attributeValue, int timeOut) {
		return driver.findElement(locator).getAttribute(attributeValue);
		
	}

}
