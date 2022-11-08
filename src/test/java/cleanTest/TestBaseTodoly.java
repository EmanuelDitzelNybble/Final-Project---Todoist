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

