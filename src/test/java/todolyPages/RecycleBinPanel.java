package todolyPages;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class RecycleBinPanel {
    public Button recycleBin = new Button(By.xpath("//td[text()='Recycle Bin']"),"[Recycle Bin] button on recycle bin panel");
    public Button dropDownBtn = new Button(By.xpath("//table[@class='ProjItemTable']//td[text()='Recycle Bin']"), "[Options] drop-down button in recycle bin panel");
    public Button emptyBinBtn = new Button(By.id("recycleContextMenu"), "[Empty Recycle bin] in recycle bin panel");
    //ul[@id='recycleContextMenu']
}
