package todolyPages;

import controlSelenium.Label;
import org.openqa.selenium.By;

public class MainPage {
    public Label mainPageLabel = new Label(By.xpath("//a[normalize-space()='']//img"),"[Label] in main page");
}
