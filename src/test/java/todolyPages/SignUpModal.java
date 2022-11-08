package todolyPages;

import controlSelenium.Button;
import controlSelenium.CheckBox;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class SignUpModal {
    public TextBox fullName = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"),"[Full Name] textBox in SignUp modal");
    public TextBox email = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"),"[Email] textBox in SignUp modal");
    public TextBox password = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"),"[Password] textBox in SignUp modal");
    public CheckBox termsOfServiceCheckbox = new CheckBox(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"), "[Terms of Service] checkBox in SignUp modal");
    public Button signUpButton = new Button(By.id("ctl00_MainContent_SignupControl1_ButtonSignup"),"[Signup] button in SignUp modal");

    public void signUp(String userFullName, String userEmail, String userPwd){
        fullName.setText(userFullName);
        email.setText(userEmail);
        password.setText(userPwd);
        termsOfServiceCheckbox.check();
        signUpButton.click();
    }
}
