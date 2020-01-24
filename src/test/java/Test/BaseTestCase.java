package Test;

import Session.Session;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestCase {

    ITestResult result;
    @BeforeMethod
    public void OpenSessionMobile() {


    }

    @AfterMethod
    public void closeSessionMobile() {

        result = Reporter.getCurrentTestResult();
        saveScreenshotPNG((WebDriver) Session.getSesion().getDriver());
        saveTextLog("failed and screenshot taken! LogsFailed ! ");
        attachHtml("<html><body>EYNAR HTML <br> ABC</body></html>");
        Session.getSesion().closeSession();
    }


    //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG (WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog (String message) {
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

}
