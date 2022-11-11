package cleanTest;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LogoutTestCase extends TestBaseTodoly {
        String mail = "emailexample@gmail.com";
        String pwd = "passwordfield";
    @Test
    @DisplayName("Verify if an user can Logout successfully")
    @Description("This test is to verify if a logged in user can be unlogged in.")
    @Owner("Emanuel Ditzel")
    @Epic("Logout")
    @Feature("Authentication")
    @Story("Login Story")
    @Tag("Logout")
    @Severity(SeverityLevel.CRITICAL)
    public void logout() {
        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();

        loginModal.login(mail, pwd);
        Assertions.assertTrue(navigationBar.logoutButton.isControlDisplayed(), "SignIn Error: User could not sign in.");

        navigationBar.logoutButton.waitClickable();
        navigationBar.logoutButton.click();
        Assertions.assertTrue(presentationPage.todoLyLabel.isControlDisplayed(),"Logout Error: User could not sign out");
    }
}
