package com.qa.newsroom.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.newsroom.base.BasePage;
import com.qa.newsroom.utils.Constants;
import com.qa.newsroom.utils.ElementUtils;

public class IndexPage extends BasePage{
	
	private WebDriver driver;
	
	private ElementUtils elementUtils;

	//1. By Locators: OR
	
	private By pageTitle = By.xpath("//a[@data-analytics-title='product index']");
	private By sectionHead = By.xpath("//h2[@class ='section-head']");
	private By canonicalUrl = By.xpath("//head/link[@rel='canonical']");
	
	private By firstTile = By.xpath("//*/a[@aria-label='Student IDs on iPhone and Apple Watch expand to Canada and more US universities - UPDATE - Posted on August 3, 2021']");
	
	//2 Create the constructor of the page class
	
	public IndexPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	//Page actions:  features of the page in the form of methods
	
	public String getIndexPageTitle() {
		//return elementUtils.waitForTitlePresent(Constants.INDEX_PAGE_TITLE,20);
		return driver.getTitle();
	}
	
	public boolean isSectionHeadExists() {
		List<WebElement> sectionHeader = driver.findElements(sectionHead);
		System.out.println(sectionHeader.size());
		if(sectionHeader.size() >0){
			return true;
		}
		else {return false;}
	}
	
	public String getCanonicalUrl() {
		return elementUtils.getAttributeValue(canonicalUrl, "href", 20);
	}
	
	public ArticlePage clickArticleTile() {
		
		elementUtils.doClick(firstTile, 20);
		return new ArticlePage(driver);		
	}
	
	public int getSectionHeaderCount() {
		return elementUtils.getElementsSize(sectionHead);
	}
	
	public List<String> getSectionHeaderValues() {
		
		List<String> sectionHeaderValues = new ArrayList<>();
		List<WebElement> sectionHeader = elementUtils.getElements(sectionHead);
		
		for(WebElement e : sectionHeader) {
			sectionHeaderValues.add(e.getText());
			System.out.println(e.getText());
		}
		return sectionHeaderValues;
	}
}
