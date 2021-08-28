package com.qa.newsroom.utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private Properties prop;
	private ChromeOptions chromeOptions;
	private FirefoxOptions firefoxOptions;
	
	public OptionsManager (Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
	chromeOptions = new ChromeOptions();
	if(prop.getProperty("headless").trim().equals("true")) {
		chromeOptions.addArguments("--headless");
		}
	if(prop.getProperty("incongnito").trim().equals("true")) {
		chromeOptions.addArguments("--incongnito");
	}
	return chromeOptions;
	}
	
	public FirefoxOptions getfFirefoxOptions() {
		firefoxOptions = new FirefoxOptions();
		if(prop.getProperty("headless").trim().equals("true")) {
			firefoxOptions.addArguments("--headless");
			}
		if(prop.getProperty("incongnito").trim().equals("true")) {
			firefoxOptions.addArguments("--incongnito");
		}
		return firefoxOptions;
		}
	
}