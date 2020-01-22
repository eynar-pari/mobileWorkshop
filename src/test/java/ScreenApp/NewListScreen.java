package ScreenApp;

import Controls.Button;
import Controls.TextBox;
import org.openqa.selenium.By;

public class NewListScreen {
    public TextBox titleTextBox;
    public TextBox notesTextBox;
    public Button saveButton;

    public NewListScreen(){
       titleTextBox= new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
        notesTextBox= new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
       saveButton= new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
    }
}
