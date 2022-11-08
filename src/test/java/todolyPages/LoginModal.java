package todolyPages;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LoginModal {
    public TextBox email = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail"),"[Email] textBox in Login modal");
    public TextBox password = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword"),"[Password] textBox in Login modal");
    public Button resetPasswordButton = new Button(By.xpath("//a[@class='HPLoginForgotLink']"),"[Reset your Password] button in Login modal");
    public Button loginButton = new Button(By.id("ctl00_MainContent_LoginControl1_ButtonLogin"),"[Login] button in Login modal");

    public void login(String userEmail, String userPassword){
        email.setText(userEmail);
        password.setText(userPassword);
        loginButton.click();
    }
}
