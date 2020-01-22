import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Test1 {
    private AppiumDriver driver;

    @BeforeClass
    public static void beforeClass(){
    }

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "EynarH");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity", ".ui.HomeActivity");
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void valid_UserCredential() throws MalformedURLException {
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.ImageButton")).click();
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys("eynar");
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("eynar");
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
        boolean isDisplayed=driver.findElement(By.xpath("//*[@text='eynar']")).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }

    @AfterClass
    public static void afterClass(){

    }
}
