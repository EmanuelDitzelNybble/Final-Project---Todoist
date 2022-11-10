package cleanTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Date;

public class SignUpTestCases extends TestBaseTodoly {
    String name = "userName"+ new Date().getTime();
    String pwd = "passwordfield";

    @Test
    public void register() throws InterruptedException {
        String email = "userEmail"+ new Date().getTime()+"@gmail.com";

        presentationPage.signUpButton.waitClickable();
        presentationPage.signUpButton.click();

        signUpModal.signUp(name, email, pwd);
        Assertions.assertTrue(navigationBar.logoutButton.isControlDisplayed(), "SignUp Error: User could not register.");
    }

    @Test
    public void emptyFields() throws InterruptedException {
        presentationPage.signUpButton.waitClickable();
        presentationPage.signUpButton.click();

        signUpModal.signUp("","","");
        Assertions.assertTrue(navigationBar.logoutButton.isControlDisplayed(), "SignUp Error: Please correct the missing fields.");
    }

    @Test
    public void registerWithExistingAccount() throws InterruptedException {
        String existingAccount = "emailexample@gmail.com";

        presentationPage.signUpButton.waitClickable();
        presentationPage.signUpButton.click();

        signUpModal.signUp(name, existingAccount, pwd);
        Assertions.assertFalse(navigationBar.logoutButton.isControlDisplayed(), "SignUp Error: Account with this email already exists.");
    }
}
