package Controls;

import Session.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;

public class Control {
    protected WebElement control;
    protected By locator;

    public Control(By locator){
        this.locator= locator;
    }

    protected WebElement findControl() throws NoSuchElementException {
        WebElement tmpControl= null;
        try {
            tmpControl = Session.getSesion().getDriver().findElement(locator);
            WebDriverWait wait = new WebDriverWait(Session.getSesion().getDriver(),20);
            wait.until(ExpectedConditions.elementToBeClickable(tmpControl));
        } catch (Exception e){
            System.out.println("The control was not found "+locator );
            throw new NoSuchElementException("the control was not found "+locator);
        }

        return tmpControl;
    }

    public void click() {
        control=findControl();
        control.click();
    }

    public void set(String value) {
        control=findControl();
        control.clear();
        control.sendKeys(value);
    }

    public boolean isDisplayed(){
        try {
            control=findControl();
            return control.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
