package cleanTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTestCases extends TestBaseTodoly {
    String mail = "emailexample@gmail.com";
    String pwd = "passwordfield";
    @Test
    public void login() throws InterruptedException {
        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();

        loginModal.login(mail, pwd);
        mainPage.mainPageLabel.waitVisibility();
        Assertions.assertTrue(mainPage.mainPageLabel.isControlDisplayed(),"Login Error: The user could not log in.");
    }
    @Test
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
    public void loginWithoutEmail() throws InterruptedException {
        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();

        loginModal.login("", pwd);
        Assertions.assertTrue(mainPage.inboxButton.isControlDisplayed(),"Login Error: Please, complete [Email] field with valid email.");
    }

    @Test
    public void loginWithoutPassword() throws InterruptedException {
        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();

        loginModal.login(mail, "");
        Assertions.assertTrue(mainPage.inboxButton.isControlDisplayed(),"Login Error: Please, complete [Password] field with valid data.");
    }
}
