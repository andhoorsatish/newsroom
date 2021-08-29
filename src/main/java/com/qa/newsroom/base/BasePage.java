package com.qa.newsroom.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.newsroom.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	//This is my fist commit
	
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is : " + browser);
		
		optionsManager = new OptionsManager(prop);
		
		if (browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();

			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("chrome");
			} else {
				tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("firefox");
			} else {
				tlDriver.set(new FirefoxDriver(optionsManager.getfFirefoxOptions()));
			}
		}

		else if (browser.equalsIgnoreCase("safari")) {
			tlDriver.set(new SafariDriver());
		}

		else {
			System.out.println("Please pass the correct browser value : " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	/**
	 * getDriver using ThreadLocal. Synchronized 
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 * This method is used to load the properties from config.properties file.
	 * @return
	 */
	public Properties init_prop() {
		 prop = new Properties();
		 try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/qa/newsroom/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return prop;
	}
	
	//This method is used to take the screen shot and will return the path of the screen shot
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;		
	}
	
	public void init_remoteDriver(String browser) {
		
		if(browser.equals("chrome")) {
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, optionsManager.getChromeOptions());
			
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(browser.equals("firefox")) {
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsManager.getfFirefoxOptions());
			
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
