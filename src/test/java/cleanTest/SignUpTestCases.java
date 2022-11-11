package cleanTest;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import javax.swing.*;
import java.util.Date;

public class SignUpTestCases extends TestBaseTodoly {
    String name = "userName"+ new Date().getTime();
    String pwd = "passwordfield";

    @Test
    @DisplayName("Verify if a user can register successfully")
    @Description("This test case is to verify if a new user is able to register successfully")
    @Owner("Emanuel Ditzel")
    @Epic("Registration")
    @Feature("Authentication")
    @Story("Registration")
    @Tag("SignUpTest")
    @Severity(SeverityLevel.CRITICAL)
    public void register() throws InterruptedException {
        String email = "userEmail"+ new Date().getTime()+"@gmail.com";

        presentationPage.signUpButton.waitClickable();
        presentationPage.signUpButton.click();

        signUpModal.signUp(name, email, pwd);
        Assertions.assertTrue(navigationBar.logoutButton.isControlDisplayed(), "SignUp Error: User could not register.");
    }

    @Test
    @DisplayName("Verify if a user can register without filling any Signup field")
    @Description("This test case is to verify if a user can register without any information given in Signup modal")
    @Owner("Emanuel Ditzel")
    @Epic("Registration")
    @Feature("Authentication")
    @Story("Registration")
    @Tag("SignUpTest")
    @Severity(SeverityLevel.CRITICAL)
    public void emptyFieldsSignUpModal() throws InterruptedException {
        presentationPage.signUpButton.waitClickable();
        presentationPage.signUpButton.click();

        signUpModal.signUp("","","");
        Assertions.assertTrue(navigationBar.logoutButton.isControlDisplayed(), "SignUp Error: Please correct the missing fields.");
    }

    @Test
    @DisplayName("Verify if a user cannot register with an already created account")
    @Description("This test case is to verify that a user cannot register with an already created account.")
    @Owner("Emanuel Ditzel")
    @Epic("Registration")
    @Feature("Authentication")
    @Story("Registration")
    @Tag("SignUpTest")
    @Severity(SeverityLevel.CRITICAL)
    public void registerWithExistingAccount() throws InterruptedException {
        String existingAccount = "emailexample@gmail.com";

        presentationPage.signUpButton.waitClickable();
        presentationPage.signUpButton.click();

        signUpModal.signUp(name, existingAccount, pwd);
        Assertions.assertFalse(navigationBar.logoutButton.isControlDisplayed(), "SignUp Error: Account with this email already exists.");
    }
}
