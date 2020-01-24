package Test;

import ScreenApp.MainScreen;
import ScreenApp.NewListScreen;
import Session.Session;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

@Feature("Feature : User")
@Epic("Epic : Administration")
public class TestCase1 extends BaseTestCase {

    MainScreen mainScreen = new MainScreen();
    NewListScreen newListScreen = new NewListScreen();

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {

    }

    @Owner("Eynar Pari")
    @Story("Story: Creation List Check")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Description : This test is to verify the creatiion of task")
    @Test (priority = 1,description = "Title : Verify if the commons user can create a task")
    @Issue("JIRA 1234")
    @TmsLink("http://jira.com/123123")
    @Link("link bug")
    public void createATask() throws MalformedURLException {
        String name="EYNAR3";
        mainScreen.plusButton.click();
        newListScreen.titleTextBox.set(name);
        newListScreen.notesTextBox.set(name);
        newListScreen.saveButton.click();
        Assert.assertTrue(mainScreen.isTaskDisplayed(name),"ERROR the task was not created");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException, MalformedURLException {
        Session.getSesion().closeSession();
    }
}
