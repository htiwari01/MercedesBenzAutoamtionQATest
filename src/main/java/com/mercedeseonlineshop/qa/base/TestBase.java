package com.mercedeseonlineshop.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.mercedeseonlineshop.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	static String path = System.getProperty("user.dir");
	
	
	public TestBase(){
		try {
			//Read config file for all the configuration
			prop = new Properties();
			FileInputStream ip = new FileInputStream(path + "/src/main"
					+ "/java/com/mercedeseonlineshop/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/himanshu.tiwari/Documents/SeleniumWork/HandsOnWork/chromedriver");
			//To disable the cookies in Chrome
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			Map<String, Object> profile = new HashMap<String, Object>();
			Map<String, Object> contentSettings = new HashMap<String, Object>();
			contentSettings.put("cookies",2);
			profile.put("managed_default_content_settings",contentSettings);
			prefs.put("profile",profile);
			options.setExperimentalOption("prefs",prefs); 
			
			driver = new ChromeDriver(options);
		}else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/himanshu.tiwari/Documents/SeleniumWork/HandsOnWork/geckodriver");
			//To disable the cookies in FF
			DesiredCapabilities caps = new DesiredCapabilities();
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("network.cookie.cookieBehavior",2);
			caps.setCapability(FirefoxDriver.PROFILE,profile);
		}
		//
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitWait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	

}
