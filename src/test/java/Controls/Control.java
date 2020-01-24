package Controls;

import Session.Session;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Control {
    protected WebElement control;
    protected By locator;
    protected String myName;


    public Control(By locator, String myName){
        this.locator= locator;
        this.myName=myName;
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
        stepLogger("Click on "+myName);
        control.click();
    }

    public void set(String value) {
        control=findControl();
        stepLogger("Set '"+value+"' on "+myName);
        control.clear();
        control.sendKeys(value);
    }

    public boolean isDisplayed(){
        try {
            control=findControl();
            stepLogger("The ["+myName+"] is displayed");
            return control.isDisplayed();
        }catch (Exception e){
            stepLogger("The ["+myName+"] is not displayed");
            return false;
        }
    }

    @Step("{0}")
    public void stepLogger(String accion){
    }

}
