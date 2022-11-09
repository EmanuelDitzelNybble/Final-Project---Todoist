package cleanTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class SettingsTestCases extends TestBaseTodoly {
    String name = "Emanuel";
    String newName = "Juan";
    String mail = "Newmail@gmail.com";
    String generatedMail = getAlphaNumericString(8)+"@gmail.com";
    String generatedPwd = getAlphaNumericString(8);
    String newGeneratedPwd = getAlphaNumericString(7);
    @Test
    public void changePassword() throws InterruptedException {
        presentationPage.signUpButton.waitClickable();
        presentationPage.signUpButton.click();

        signUpModal.signUp(name,generatedMail, generatedPwd);

        navigationBar.settingsButton.waitClickable();
        navigationBar.settingsButton.click();

        settingsModal.oldPassword.setText(generatedPwd);
        settingsModal.newPassword.setText(newGeneratedPwd);
        settingsModal.okBtn.click();
        Assertions.assertNotEquals(generatedPwd, newGeneratedPwd, "Error setting new password");

        navigationBar.logoutButton.waitClickable();
        navigationBar.logoutButton.click();

        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();

        loginModal.login(generatedMail, newGeneratedPwd);
        Assertions.assertTrue(navigationBar.logoutButton.isControlDisplayed(), "Login Error: The user could not login.");
    }

    @Test
    public void deleteAccount() throws InterruptedException {
        presentationPage.signUpButton.waitClickable();
        presentationPage.signUpButton.click();

        signUpModal.signUp(name,generatedMail, generatedPwd);

        navigationBar.settingsButton.waitClickable();
        navigationBar.settingsButton.click();

        settingsModal.accountTab.waitClickable();
        settingsModal.accountTab.click();
        settingsModal.deleteAccountBtn.waitClickable();
        settingsModal.deleteAccountBtn.click();
        Session.getInstance().getBrowser().switchTo().alert().accept();

        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();

        loginModal.email.waitToElementToBePresent();
        loginModal.login(generatedMail, generatedPwd);
        Assertions.assertFalse(navigationBar.logoutButton.isControlDisplayed(), "Configuration Error: could not delete account");
    }

    @Test
    public void newAndOldPwdEquals() throws InterruptedException {
        presentationPage.signUpButton.waitClickable();
        presentationPage.signUpButton.click();

        signUpModal.signUp(name,generatedMail, generatedPwd);

        navigationBar.settingsButton.waitClickable();
        navigationBar.settingsButton.click();

        settingsModal.oldPassword.setText(generatedPwd);
        settingsModal.newPassword.setText(generatedPwd);
        settingsModal.okBtn.click();
        Assertions.assertNotEquals(generatedPwd, generatedPwd, "Error setting new password");
    }

    @Test
    public void cancelSettingsChanges() throws InterruptedException {
        presentationPage.signUpButton.waitClickable();
        presentationPage.signUpButton.click();

        signUpModal.signUp(name,generatedMail, generatedPwd);

        navigationBar.settingsButton.waitClickable();
        navigationBar.settingsButton.click();

        settingsModal.fullName.setText(name);
        settingsModal.email.setText(mail);
        settingsModal.dropDownTimezoneBtn.click();
        settingsModal.buenosAiresOption.waitClickable();
        settingsModal.buenosAiresOption.click();
        settingsModal.cancelBtn.click();

        navigationBar.settingsButton.waitClickable();
        navigationBar.settingsButton.click();
        Assertions.assertNotEquals(settingsModal.email.getText(), mail, "");
    }

    @Test
    public void changeName() throws InterruptedException {
        presentationPage.signUpButton.waitClickable();
        presentationPage.signUpButton.click();

        signUpModal.signUp(name,generatedMail, generatedPwd);

        navigationBar.settingsButton.waitClickable();
        navigationBar.settingsButton.click();

        settingsModal.fullName.waitClickable();
        settingsModal.fullName.setText(newName);
        settingsModal.okBtn.click();

        navigationBar.settingsButton.waitClickable();
        navigationBar.settingsButton.click();
        settingsModal.fullName.waitClickable();
        Assertions.assertNotEquals(settingsModal.fullName.getText(), name,"Configuration Error: name has not been modified");
    }
}


