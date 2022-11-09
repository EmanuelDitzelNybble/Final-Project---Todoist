package todolyPages;

import controlSelenium.Control;
import org.openqa.selenium.By;

public class TaskSection {
    public Control lastItemCreated = new Control(By.xpath("//ul[@id=\"mainItemList\"]/li[last()]//*[@class=\"ItemContentDiv\"]"),"Last item created in task section control");
}
