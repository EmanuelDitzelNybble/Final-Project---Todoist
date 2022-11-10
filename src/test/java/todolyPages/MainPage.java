package todolyPages;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class MainPage {
     public Label mainPageLabel = new Label(By.xpath("//a[normalize-space()='']//img"),"[Label] on main page");
     public Button inboxButton = new Button(By.xpath("//td[text()='Inbox']"),"[Inbox] button on main page");
}
