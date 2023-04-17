package WebApps;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class capabili {
	public AndroidDriver<AndroidElement> capa1() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(MobileCapabilityType.DEVICE_NAME,"parthi");
dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
dc.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"C://Users//parth//Documents//workspace-spring-tool-suite-4-4.16.0.RELEASE//Appium//chromedriver.exe");
dc.setCapability("appium:chromeOptions",ImmutableMap.of("w3c",false));
AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
return null;
}}