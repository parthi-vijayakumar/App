package Nativeapp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bsh.Capabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//for tapoptions
import static io.appium.java_client.touch.TapOptions.tapOptions;
//for elemet
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class capabality extends capabilities {
	AndroidDriver<AndroidElement> driver; // using android driver to click on android element

	@BeforeTest
	public void bt() throws MalformedURLException {
		driver = capi();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(enabled = true)
	public void prefrences() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
//driver.findElements(By.className("android.widget.RelativeLayout")).get(1).click();
// when u are using androiduiautomator to identify an element using an attribute,then 
//u have to use uiselector method for selecting the attribute.
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("partha");
		driver.hideKeyboard();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	@Test(enabled = true)
	public void notification() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.openNotifications();
		Thread.sleep(3000);
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Appium Settings\")").click();
		driver.findElements(By.className("android.widget.ImageButton")).get(0).click();
		Thread.sleep(3000);
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Battery\")").click();
	}

	@Test(enabled = true)
	public void view() throws InterruptedException {
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
//driver.findElement(MobileBy.AccessibilityId("Views")).click();
//if you want to scroll then you need 3things
//Uiautomator.uiselector,uicrollintoview
		Thread.sleep(8000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
//driver.findElementsByAccessibilityId("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"); this is 2nd way of scrolling
		AndroidElement clickable = driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)");
		Dimension print = clickable.getSize();
		System.out.println(print);
	}

	@Test(enabled = true)
	public void tapandlongpress() {
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		AndroidElement ele = driver.findElement(MobileBy.AccessibilityId("Expandable Lists"));
		TouchAction ta = new TouchAction(driver);
		ta.tap(tapOptions().withElement(element(ele))).perform();
		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
		AndroidElement elel = driver.findElementByAndroidUIAutomator("text(\"Fish Names\")");
// ta.longPress(LongPressOptions().withElement(element(elel)).withDuration(ofSeconds(3)));
		ta.longPress(longPressOptions().withElement(element(elel)).withDuration(ofSeconds(3))).release().perform();
//  String sample= driver.findElements(By.className)("android.widget.TextView")).get(0).
	}

	@Test(enabled = true)
	public void swipe() {
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		TouchAction ta = new TouchAction(driver);
		AndroidElement ele1 = driver.findElement(MobileBy.AccessibilityId("12"));
		AndroidElement ele2 = driver.findElement(MobileBy.AccessibilityId("5"));
		ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(2))).moveTo(element(ele2))
				.release().perform();
	}

	@Test(enabled = true)
	public void draganddrop() throws InterruptedException {
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		TouchAction ta = new TouchAction(driver);
		AndroidElement first = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
		AndroidElement second = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
		Thread.sleep(3000);
		ta.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(5))).moveTo(element(second))
				.release().perform();
	}

	@Test
	public void sendotp() throws InterruptedException {
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByAndroidUIAutomator("text(\"OS\")").click();
			driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
			driver.findElements(By.className("android.widget.TableRow")).get(0).click();
			driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650) 555-1212");
			driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("hiiii");
			driver.findElement(MobileBy.AccessibilityId("Send")).click();
			Thread.sleep(7000);
			driver.activateApp("com.google.android.apps.messaging");
			String element = driver
					.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
			System.out.println(element);
			driver.activateApp("io.appium.android.apis");
		}
	}
}