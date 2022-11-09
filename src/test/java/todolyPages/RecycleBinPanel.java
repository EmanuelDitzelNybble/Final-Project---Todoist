package todolyPages;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class RecycleBinPanel {
    public Button recycleBin = new Button(By.xpath("//td[text()='Recycle Bin']"),"[Recycle Bin] button on recycle bin panel");
}
