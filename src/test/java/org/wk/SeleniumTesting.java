package org.wk;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumTesting {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("platform", Platform.WINDOWS);
		capabilities.setCapability("name", "Selenium Testing");
		URL url = new URL("http://192.168.56.20:4444/wd/hub");
		driver = new RemoteWebDriver(url, capabilities);
	}

	@Test
	public void testTest() throws Exception {
		driver.get("http://www.google.pl");
		WebElement search = driver.findElement(By.id("lst-ib"));
		search.sendKeys("selenium");
		search.click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
