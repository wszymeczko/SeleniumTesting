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
import static org.junit.Assert.*;

public class SeleniumTestingTest {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setPlatform(Platform.WINDOWS);
		URL url = new URL("http://192.168.56.1:5555/wd/hub");
		driver = new RemoteWebDriver(url, capabilities);
	}

	@Test
	public void testEpo1() throws Exception {
		driver.get("http://www.epo.org");
		driver.manage().window().maximize();
		assertEquals("EPO - Home", driver.getTitle());
		WebElement patents = driver.findElement(By.linkText("Searching for patents"));
		patents.click();
		WebElement register = driver.findElement(By.linkText("European Patent Register"));
		register.click();		
		WebElement openBtn = driver.findElement(By.id("idOfButton"));
		openBtn.click();
		WebElement search = driver.findElement(By.name("query"));
		search.sendKeys("dummy");
		search.submit();
		assertEquals("European Patent Register", driver.getTitle());
	}

	@Test
	public void testEpo2() throws Exception {
		driver.get("http://www.epo.org");
		driver.manage().window().maximize();
		assertEquals("EPO - Home", driver.getTitle());
		WebElement patents = driver.findElement(By.linkText("Searching for patents"));
		patents.click();
		WebElement register = driver.findElement(By.linkText("European Patent Register"));
		register.click();		
		WebElement openBtn = driver.findElement(By.id("idOfButton"));
		openBtn.click();
		WebElement search = driver.findElement(By.name("query"));
		search.sendKeys("test");
		search.submit();
		assertEquals("European Patent Register", driver.getTitle());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
