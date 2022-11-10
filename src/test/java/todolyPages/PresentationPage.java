package todolyPages;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class PresentationPage {
    public Button loginButton = new Button(By.xpath("//img[@src='/Images/design/pagelogin.png']"), "[Login] button in Presentation page");
    public Button signUpButton = new Button(By.xpath("//img[@src='/Images/design/pagesignup.png']"), "[SignUp] button in Presentation page");
    public Label todoLyLabel = new Label(By.xpath("//a[@href='/']//img"),"[Todo.ly] label in Presentation page"); //
}
