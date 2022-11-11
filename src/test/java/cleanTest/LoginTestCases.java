package cleanTest;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LoginTestCases extends TestBaseTodoly {
    String mail = "emailexample@gmail.com";
    String pwd = "passwordfield";
    @Test
    @DisplayName("Verify if a user can log in successfully")
    @Description("This test case is to verify that a user can log in with a created account.")
    @Owner("Emanuel Ditzel")
    @Epic("Login")
    @Feature("Authentication")
    @Story("Login")
    @Tag("LoginTests")
    @Severity(SeverityLevel.CRITICAL)
    public void login() throws InterruptedException {

        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();
        loginModal.login(mail, pwd);
        mainPage.mainPageLabel.waitVisibility();
        Assertions.assertTrue(mainPage.mainPageLabel.isControlDisplayed(),"Login Error: The user could not log in.");
    }
    @Test
    @DisplayName("Verify if a validation message is displayed when the user wants to reset the password")
    @Description("This test case is to verify if a validation message is displayed when a user wants to reset his password")
    @Owner("Emanuel Ditzel")
    @Epic("Login")
    @Feature("Authentication")
    @Story("Login")
    @Tag("LoginTests")
    @Severity(SeverityLevel.NORMAL)
    public void resetPasswordValidationMsg() throws InterruptedException {
        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();

        loginModal.resetPasswordButton.waitClickable();
        loginModal.resetPasswordButton.click();
        loginModal.resetPwdEmailField.waitClickable();
        loginModal.resetPwdEmailField.setText(mail);
        loginModal.sendButton.click();
        loginModal.resetPwdValidationMessage.waitVisibility();
        Assertions.assertTrue(loginModal.resetPwdValidationMessage.isControlDisplayed(),"Error showing validation message");
    }

    @Test
    @DisplayName("Verify if a user can login with empty [Email] textBox field")
    @Description("This test is to verify if a user can log in without entering an email address.")
    @Owner("Emanuel Ditzel")
    @Epic("Login")
    @Feature("Authentication")
    @Story("Login")
    @Tag("LoginTests")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithoutEmail() throws InterruptedException {
        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();

        loginModal.login("", pwd);
        Assertions.assertTrue(mainPage.inboxButton.isControlDisplayed(),"Login Error: Please, complete [Email] field with valid email.");
    }

    @Test
    @DisplayName("Verify if a user can log in by leaving the [password] field empty")
    @Description("This test is to verify if a user can log in without entering a password.")
    @Owner("Emanuel Ditzel")
    @Epic("Login")
    @Feature("Authentication")
    @Story("Login")
    @Tag("LoginTests")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithoutPassword() throws InterruptedException {
        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();

        loginModal.login(mail, "");
        Assertions.assertTrue(mainPage.inboxButton.isControlDisplayed(),"Login Error: Please, complete [Password] field with valid data.");
    }
}

