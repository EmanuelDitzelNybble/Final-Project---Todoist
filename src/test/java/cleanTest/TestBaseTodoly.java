package cleanTest;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import singletonSession.Session;
import todolyPages.*;
import utils.GetProperties;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
@ExtendWith(TestResultExtension.class)
public class TestBaseTodoly {
        public LoginModal loginModal = new LoginModal();
        public PresentationPage presentationPage = new PresentationPage();
        public SignUpModal signUpModal = new SignUpModal();
        public NavigationBar navigationBar = new NavigationBar();
        public MainPage mainPage = new MainPage();
        public SettingsModal settingsModal = new SettingsModal();
        public TaskSection taskSection = new TaskSection();
        public ProjectPanel projectPanel = new ProjectPanel();
        public RecycleBinPanel recycleBinPanel = new RecycleBinPanel();

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
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", GetProperties.getInstance().getBrowser())
                        .put("URL", GetProperties.getInstance().getHost())
                        .put("User", GetProperties.getInstance().getUser())
                        .put("Pwd", GetProperties.getInstance().getPwd())
                        .build(), System.getProperty("user.dir")
                        + "/build/allure-results/");
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }

    @Attachment(value = "screenshot",type = "image/png")
    public static byte[] attach(){
        return ((TakesScreenshot) Session.getInstance().getBrowser()).getScreenshotAs(OutputType.BYTES);
    }
}

