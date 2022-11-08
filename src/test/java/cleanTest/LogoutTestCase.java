package cleanTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogoutTestCase extends TestBaseTodoly {
        String mail = "emailexample@gmail.com";
        String pwd = "passwordfield";
    @Test
    public void logout() throws InterruptedException {
        presentationPage.loginButton.waitClickable();
        presentationPage.loginButton.click();

        loginModal.login(mail, pwd);
        Assertions.assertTrue(navigationBar.logoutButton.isControlDisplayed(), "SignIn Error: User could not sign in.");

        navigationBar.logoutButton.waitClickable();
        navigationBar.logoutButton.click();
        Assertions.assertTrue(presentationPage.todoLyLabel.isControlDisplayed(),"Logout Error: User could not sign out");
    }
}
