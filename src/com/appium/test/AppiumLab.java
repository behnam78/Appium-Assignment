package com.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumLab {
	private AndroidDriver driver;

	  @Before
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("udid", "emulator-5554");
	    desiredCapabilities.setCapability("BROWSER_NAME", "Android");
	    desiredCapabilities.setCapability("VERSION", "9.0");
	    desiredCapabilities.setCapability("deviceName", "Nexus S API 28");
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	  }

	  @Test
	  public void sampleTest() {
	    MobileElement el1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_6");
	    el1.click();
	    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("multiply");
	    el2.click();
	    MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("divide");
	    el4.click();
	    MobileElement el5 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_9");
	    el5.click();
	    MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("equals");
	    el6.click();
	    MobileElement el7 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
	    el7.click();
	    assertEquals("2", el7.getText());
	  }

	  @After
	  public void tearDown() {
	    driver.quit();
	  }

}
