package FactoryDevices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidCloud implements IDevices {

    public static String userName = "gamersite1";
    public static String accessKey = "iq8NKxgpVmPZL7uZeqF5";

    @Override
    public AppiumDriver create() {
        AndroidDriver<AndroidElement> driver = null;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("device", "Samsung Galaxy S9");
        caps.setCapability("os_version", "8.0");
        caps.setCapability("project", "My First Project");
        caps.setCapability("build", "My First Build");
        caps.setCapability("name", "Bstack-[Java] Sample Test");
        caps.setCapability("app", "bs://c27a56f5bb28feb796d78b5480593808b4651e46");
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
