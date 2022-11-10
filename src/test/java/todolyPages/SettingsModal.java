package todolyPages;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class SettingsModal {
    public TextBox fullName = new TextBox(By.id("FullNameInput"),"[Full Name] textBox on settings modal");
    public TextBox email = new TextBox(By.id("EmailInput"),"[Full Name] textBox on settings modal");
    public Button dropDownTimezoneBtn = new Button(By.id("DropDownTimezone"),"[Timezone] drop-down list button on settings modal");
    public Button buenosAiresOption = new Button(By.xpath("//option[@value='Argentina Standard Time']"),"Argentina standard time option on timezone drop-down list");
    public TextBox oldPassword = new TextBox(By.id("TextPwOld"),"[Old Password] button on settings modal");
    public TextBox newPassword = new TextBox(By.id("TextPwNew"),"[New Password] button on settings modal");
    public Button okBtn = new Button(By.xpath("//span[text()='Ok']"),"[Ok] button on settings modal");
    public Button cancelBtn = new Button(By.xpath("//span[text()='Cancel']"), "[Cancel] button on settings modal");
    public Button accountTab = new Button(By.xpath("//a[text()='Account']"),"[Account] tab on settings modal");
    public Button deleteAccountBtn = new Button(By.id("DeleteAccountBtn"), "[Account] button on settings page");
    public Button profileBtn = new Button(By.xpath("//a[text()='Profile']"),"[Profile] tab on settings modal");
}
