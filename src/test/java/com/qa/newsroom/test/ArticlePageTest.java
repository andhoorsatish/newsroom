package com.qa.newsroom.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.newsroom.base.BaseTest;
import com.qa.newsroom.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(ExtentReportListener.class)

@Epic("Epic Name")
@Story("Story number")


public class ArticlePageTest extends BaseTest{
	
	@BeforeClass
	public void articlePageTest() {		
		articlePage = indexPage.clickArticleTile();
	}
	@Description ("Verify the Article Page title")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1)
	public void getArticleTitleTest() {		
		Assert.assertEquals(articlePage.getArticlePageTitle(), Constants.ARTICLE_PAGE_TITLE, "Article Page title is incorrect");
	}
	
	@Description ("Verify the Article Page Headline")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=2)
	public void getArticleHeadlineTest() {
		Assert.assertEquals(articlePage.getArticlePageHeadline(), Constants.ARTICLE_PAGE_HEADLINE, "Article page Headline is incorrect");
	}
	
	@Description ("Verify the Canonical URL of Article Page")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3)
	public void getArticleCanonicalURLTest() throws InterruptedException {
		Assert.assertEquals(articlePage.getArticlePageCanonicalUrl(), Constants.ARTICLE_PAGE_CANONICAL_URL, "Canonical URL IS INCORRECT");
	}
	
	@Description ("Verify the Download Link Title of Article Page")
	@Severity(SeverityLevel.TRIVIAL)
	@Test(priority = 4)
	
	public void verifyDownloadLinkTitleTest() {
		Assert.assertEquals(articlePage.getArticlePageDowloadTitle(), Constants.ARTICLE_PAGE_DOWNLOAD_TITLE, "Download Title is Incorrect");
	}

}
