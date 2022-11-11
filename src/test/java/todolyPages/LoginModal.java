package todolyPages;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LoginModal {
    public TextBox email = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail"),"[Email] textBox in Login Modal");
    public TextBox password = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword"),"[Password] textBox in Login Modal");
    public Button resetPasswordButton = new Button(By.xpath("//a[@class='HPLoginForgotLink']"),"[Reset your Password] button in Login Modal");
    public Button loginButton = new Button(By.id("ctl00_MainContent_LoginControl1_ButtonLogin"),"[Login] button in Login Modal");
    public TextBox resetPwdEmailField = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxForgotPwdEmail"),"[Reset Password] textBox in Login Modal");
    public Button sendButton = new Button(By.id("ctl00_MainContent_LoginControl1_ButtonSend"),"[Send] button for reset password in Login Modal");
    public Label resetPwdValidationMessage = new Label(By.xpath("//span[text()='An email has been sent with a link where you can change your password.']"), "[Validation Message] label in Presentation Page");
    public void login(String userEmail, String userPassword){
        email.setText(userEmail);
        password.setText(userPassword);
        loginButton.click();
    }
}
