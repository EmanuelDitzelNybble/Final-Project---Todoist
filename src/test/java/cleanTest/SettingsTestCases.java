package cleanTest;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import singletonSession.Session;

public class SettingsTestCases extends TestBaseTodoly {
    String name = "Emanuel";
    String newName = "Juan";
    String mail = "Newmail@gmail.com";
    String generatedMail = getAlphaNumericString(8)+"@gmail.com";
    String generatedPwd = getAlphaNumericString(8);
    String newGeneratedPwd = getAlphaNumericString(7);
    @Test
    @DisplayName("Verify that a user can successfully change the password.")
    @Description("This test is to verify that a user can change the password of his account.")
    @Owner("Emanuel Ditzel")
    @Epic("Account Settings")
    @Feature("Change Password")
    @Story("Account Settings Story")
    @Tag("SettingsTests")
    @Severity(SeverityLevel.CRITICAL)
    public void changePassword() {
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
    @DisplayName("Verify that the user can delete their account")
    @Description("This test is to validate that the user can delete their account in [Settings] section")
    @Owner("Emanuel Ditzel")
    @Epic("Account Settings")
    @Feature("Delete Account")
    @Story("Account Settings Story")
    @Tag("SettingsTests")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteAccount() {
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
    @DisplayName("Verify that the user cannot use the same password to change password")
    @Description("This test case is to verify that a user cannot use the same password to create a new one.")
    @Owner("Emanuel Ditzel")
    @Epic("Account Settings")
    @Feature("Change Password")
    @Story("Account Settings Story")
    @Tag("Bugs")
    @Severity(SeverityLevel.NORMAL)
    public void newAndOldPwdEquals() {
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
    @DisplayName("Verify that the user can cancel changes made in [Settings].")
    @Description("This test case is to verify that a user can cancel all changes made in [Settings] modal")
    @Owner("Emanuel Ditzel")
    @Epic("Account Settings")
    @Feature("Cancel Configuration Changes")
    @Story("Account Settings Story")
    @Tag("SettingsTests")
    @Severity(SeverityLevel.NORMAL)
    public void cancelSettingsChanges() {
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

    @DisplayName("Verify that a user can change their name")
    @Description("This test is to verify that a user can change his name from settings modal")
    @Owner("Emanuel Ditzel")
    @Epic("Account Settings")
    @Feature("Change Name")
    @Story("Account Settings Story")
    @Tag("SettingsTests")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest
    @CsvSource({
            "1", "20", "80", "450"
    })
    public void changeName(int numbers) {
        newName = getAlphaNumericString(numbers);

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
