package todolyPages;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class NavigationBar {
    public Button logoutButton = new Button(By.id("ctl00_HeaderTopControl1_LinkButtonLogout"),"[Logout] button in Navigation bar");
    public Button settingsButton = new Button(By.xpath("//a[text()='Settings']"), "[Settings] button on main page");
}
