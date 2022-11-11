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
    public void login() {

        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();
        loginModal.login(mail, pwd);
        mainPage.mainPageLabel.waitVisibility();
        Assertions.assertTrue(navigationBar.logoutButton.isControlDisplayed(),"Login Error: The user could not log in.");
    }
    @Test
    @DisplayName("Verify if a validation message is displayed when the user wants to reset the password by entering invalid mail")
    @Description("This test case is to verify if a validation message is displayed when a user wants to enter an invalid mail")
    @Owner("Emanuel Ditzel")
    @Epic("Login")
    @Feature("Authentication")
    @Story("Login")
    @Tag("LoginTests")
    @Severity(SeverityLevel.NORMAL)
    public void verifyValidationForInvalidMail()  {
        String invalidMail = "DFDF@gmail";
        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();

        loginModal.resetPasswordButton.waitClickable();
        loginModal.resetPasswordButton.click();
        loginModal.resetPwdEmailField.waitClickable();
        loginModal.resetPwdEmailField.setText(invalidMail);
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
    public void loginWithoutEmail() {
        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();

        loginModal.login("", pwd);
        Assertions.assertFalse(navigationBar.logoutButton.isControlDisplayed(),"Login Error: Please, complete [Email] field with valid email.");
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
    public void loginWithoutPassword() {
        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();

        loginModal.login(mail, "");
        Assertions.assertFalse(navigationBar.logoutButton.isControlDisplayed(),"Login Error: Please, complete [Password] field with valid data.");
    }
}

