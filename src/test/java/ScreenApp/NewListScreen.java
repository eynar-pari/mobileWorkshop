package ScreenApp;

import Controls.Button;
import Controls.TextBox;
import org.openqa.selenium.By;

public class NewListScreen {
    public TextBox titleTextBox;
    public TextBox notesTextBox;
    public Button saveButton;

    public NewListScreen(){
       titleTextBox= new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"),"[title] textbox");
        notesTextBox= new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"),"[notes] textbox");
       saveButton= new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"),"[save] button");
    }
}
