package ScreenApp;

import Controls.Button;
import Controls.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button plusButton;

    public MainScreen(){
        plusButton= new Button(By.id("com.vrproductiveapps.whendo:id/fab"));
    }

    public boolean isTaskDisplayed(String nameTask){
        Label label = new Label(By.xpath("//*[@text='"+nameTask+"']"));
        return label.isDisplayed();
    }


}
