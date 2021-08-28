package com.qa.newsroom.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String INDEX_PAGE_TITLE = "Newsroom1 - Apple";
	public static final String INDEX_CANONICAL_URL = "https://www.apple.com/newsroom/";
	public static final int INDEX_HEADER_COUNT = 3;
	
	
	public static final String ARTICLE_PAGE_TITLE = "Student IDs on iPhone and Apple Watch expand to Canada and more US universities - APPLE";
	public static final String ARTICLE_PAGE_HEADLINE = "Student IDs on iPhone and Apple Watch expand to Canada and more US universities";
	public static final String ARTICLE_PAGE_CANONICAL_URL = "https://www.apple.com/newsroom/2021/08/student-ids-on-iphone-and-apple-watch-expand-to-canada-and-more-us-universities/";
	public static final String ARTICLE_PAGE_DOWNLOAD_TITLE = "Images of Apple Wallet Student ID";
	
	public static List<String> IndexPageHeaderValues() {
		List<String> indexPageHeaderValues = new ArrayList<>();		
		indexPageHeaderValues.add("Latest News");
		indexPageHeaderValues.add("Featured Stories");
		indexPageHeaderValues.add("More from Newsroom");	
		
		return indexPageHeaderValues;
	}

}
