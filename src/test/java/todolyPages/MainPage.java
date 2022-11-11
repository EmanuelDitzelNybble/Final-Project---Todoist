package todolyPages;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class MainPage {
     public Label mainPageLabel = new Label(By.xpath("//a[normalize-space()='']//img"),"[Todo.ly] label in Main Page");
     public Button inboxButton = new Button(By.xpath("//td[text()='Inbox']"),"[Inbox] button in Main Page");
}
