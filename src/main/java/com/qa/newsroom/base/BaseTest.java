package com.qa.newsroom.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.newsroom.pages.ArticlePage;
import com.qa.newsroom.pages.IndexPage;
import com.qa.newsroom.utils.ElementUtils;

public class BaseTest {
	
	public BasePage basePage;
	public ArticlePage articlePage;
	public IndexPage indexPage;
	
	public Properties prop;
	public WebDriver driver; 
	
	@Parameters({"browserName", "version"})
	@BeforeTest
	public void setupMethod() {
		basePage = new BasePage();	
		prop = basePage.init_prop();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);				
		driver.get(prop.getProperty("url"));
		
		indexPage = new IndexPage(driver);		
	}	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
