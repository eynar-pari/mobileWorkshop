package ScreenApp;

import Controls.Button;
import Controls.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button plusButton;

    public MainScreen(){
        plusButton= new Button(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.ImageButton"));
    }

    public boolean isTaskDisplayed(String nameTask){
        Label label = new Label(By.xpath("//*[@text='"+nameTask+"']"));
        return label.isDisplayed();
    }


}
