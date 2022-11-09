package cleanTest;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import singletonSession.Session;
import todolyPages.*;
import utils.GetProperties;

public class TestBaseTodoly {

        public LoginModal loginModal = new LoginModal();
        public PresentationPage presentationPage = new PresentationPage();
        public SignUpModal signUpModal = new SignUpModal();
        public NavigationBar navigationBar = new NavigationBar();
        public MainPage mainPage = new MainPage();
        public SettingsModal settingsModal = new SettingsModal();
        public TaskSection taskSection = new TaskSection();
        public ProjectPanel projectPanel = new ProjectPanel();

    static String getAlphaNumericString(int n)
    {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
        @BeforeEach
        public void setup(){
            Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
        }
        @AfterEach
        public void cleanup(){
            attach();
            Session.getInstance().closeBrowser();
        }
        @Attachment(value = "screenshot",type = "image/png")
        private byte[] attach(){
            return ((TakesScreenshot) Session.getInstance().getBrowser()).getScreenshotAs(OutputType.BYTES);
        }
}

