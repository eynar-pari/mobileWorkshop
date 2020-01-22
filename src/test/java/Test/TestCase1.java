package Test;

import ScreenApp.MainScreen;
import ScreenApp.NewListScreen;
import Session.Session;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCase1 {

    MainScreen mainScreen = new MainScreen();
    NewListScreen newListScreen = new NewListScreen();

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {

    }

    @Test
    public void createATask() throws MalformedURLException {
        String name="EYNAR3";
        mainScreen.plusButton.click();
        newListScreen.titleTextBox.set(name);
        newListScreen.notesTextBox.set(name);
        newListScreen.saveButton.click();
        Assert.assertTrue(mainScreen.isTaskDisplayed(name+9999),"ERROR the task was not created");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException, MalformedURLException {
        Session.getSesion().closeSession();
    }
}
