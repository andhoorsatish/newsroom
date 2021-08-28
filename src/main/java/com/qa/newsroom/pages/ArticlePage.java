package com.qa.newsroom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.newsroom.base.BasePage;

import io.qameta.allure.Step;

public class ArticlePage extends BasePage{
	
	private WebDriver driver;
	
	private By articlePageTile = By.xpath("//h1[@class = 'hero-headline']");
	private By canonicalUrlArticle = By.xpath("//head/link[@rel='canonical']");
	private By downloadImages = By.xpath("//div/p[@class='docsanddownloads__text']");
	
	public ArticlePage(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Checking the Article Page Title...")
	public String getArticlePageTitle() {
		return driver.getTitle();
	}
	@Step("Checking the Article Page Headline...")
	public String getArticlePageHeadline(){
		
		if(driver.findElement(articlePageTile).isDisplayed()) {
			return driver.findElement(articlePageTile).getText();
		}
		return null;
	}
	@Step("Checking the Article Page Canonical URL...")
	public String getArticlePageCanonicalUrl(){
		return driver.findElement(canonicalUrlArticle).getAttribute("href");
	}
	
	@Step("Checking the Article Page Download Images Title...")
	public String getArticlePageDowloadTitle() {
		
		if(driver.findElement(downloadImages).isDisplayed()) 
		{
			return driver.findElement(downloadImages).getText();
		}
		return null;
	}
}
