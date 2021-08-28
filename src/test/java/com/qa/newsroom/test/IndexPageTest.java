package com.qa.newsroom.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.newsroom.base.BaseTest;
import com.qa.newsroom.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

//@Listeners(ExtentReportListener.class)

public class IndexPageTest extends BaseTest{
	
	@Description ("Verify the Index Page title")
	@Severity(SeverityLevel.CRITICAL)
	@Test (priority = 1)
	public void verifyIndexPageTitleTest() throws InterruptedException {
		String title =   indexPage.getIndexPageTitle();
		System.out.println("Login Page tilte = "+title);	
		Assert.assertEquals(title, Constants.INDEX_PAGE_TITLE, "Index Page title is incorrect");		
	}
	
	@Description ("Verify the Index Page Canonical Page Url")
	@Severity(SeverityLevel.BLOCKER)
	@Test (priority = 2)
	public void verifyCanonicalURLTest() {
		Assert.assertEquals(indexPage.getCanonicalUrl(), Constants.INDEX_CANONICAL_URL, "Canonical URL is incorrect");
	}
	@Description ("Verify the Index Page Header Counter")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 3)
	public void verifyHeaderCountTest() {
		Assert.assertEquals(indexPage.getSectionHeaderCount(), Constants.INDEX_HEADER_COUNT);		
	}
	
	@Description ("Verify the Index Page Header Values")
	@Test (priority=4)
	public void verifySectionHeaderValues() {		
		Assert.assertEquals(indexPage.getSectionHeaderValues(), Constants.IndexPageHeaderValues());		
	}

}
