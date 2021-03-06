package com.sid.mobile.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverProvider {

	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static String driverPath = System.getProperty("user.dir") + "/drivers";
	public static AppiumDriver<WebElement> bdriver;
	public static AppiumDriver<MobileElement> mdriver;

	public static AppiumDriver<WebElement> getAndroidBrowserDriver() throws MalformedURLException {
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability("chromedriverExecutableDir", driverPath);

		// Instantiate android browser driver
		bdriver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		bdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return bdriver;
	}

	public static AppiumDriver<MobileElement> getAndroidMobileDriver() throws MalformedURLException {
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

		// Instantiate android mobile driver
		mdriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		mdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return mdriver;
	}

	public static AppiumDriver<WebElement> getIOSBrowserDriver() throws MalformedURLException {
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");

		// Instantiate ios browser driver
		bdriver = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		bdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return bdriver;
	}

	public static AppiumDriver<MobileElement> getIOSMobileDriver() throws MalformedURLException {
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

		// Instantiate ios mobile driver
		mdriver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		mdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return mdriver;
	}
	
	public static DesiredCapabilities getCapabilities(String platformName, String platformVersion, String deviceName, String browserName) {
		capabilities = null;
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName); // Android / iOS
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion); // 8.1 / 11.0
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName); // emulator-5554 / emulator-5554
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName); // Chrome / Safari
		return capabilities;
	}
	
	public static AppiumDriver<MobileElement> getAndroidMobileDriverTemp() throws MalformedURLException {
		Path currentRelativePath = Paths.get("");
		String appPath = currentRelativePath.toAbsolutePath().toString();
		appPath =  appPath + "/apps/VodQA.apk";
		
		System.out.println("APP PATH :" + appPath);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.APP, appPath);
		capabilities.setCapability("noReset", false);
		

		// Instantiate android mobile driver
		mdriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		mdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return mdriver;
		
	}
	
	public static AppiumDriver<WebElement> getAndroidDriver() throws MalformedURLException {
		AppiumDriver<WebElement> driver;
		Path currentRelativePath = Paths.get("");
		String appPath = currentRelativePath.toAbsolutePath().toString();
		appPath =  appPath + "/apps/VodQA.apk";
		
		System.out.println("APP PATH :" + appPath);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.APP, appPath);
		capabilities.setCapability("noReset", false);
		

		// Instantiate android mobile driver
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
		
	}
}
