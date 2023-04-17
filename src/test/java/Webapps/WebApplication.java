package Webapps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import WebApps.capabili;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebApplication {
	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void bt() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "parthi");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,
				"C://Users//parth//Documents//workspace-spring-tool-suite-4-4.16.0.RELEASE//Appium//chromedriver.exe");
		dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);

	}

	@Test
	public void tc () throws InterruptedException {{
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("moolyaed");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		List<AndroidElement> links = driver.findElements(By.tagName("a"));
		links.size();
		System.out.println(links.size());
		//     for(int i=0;i<links.size();i++) {
		//         Thread.sleep(3000);
		//      System.out.println(links.get(i).getText());
		//       Thread.sleep(5000);
		//        System.out.println(links.get(i).getAttribute("href"));
		Thread.sleep(3000);
		AndroidElement star= driver.findElement(By.xpath("//[@class='//[@class='TbwUpd NJjxre']"));
		Thread.sleep(3000);
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", star);
		star.click();
}
}}