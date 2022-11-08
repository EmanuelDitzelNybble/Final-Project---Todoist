package cleanTest;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import singletonSession.Session;
import utils.GetProperties;

public class TestBaseTodoly {

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

