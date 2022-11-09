package controlSelenium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

import java.time.Duration;

public class Control {

    protected By locator;
    protected WebElement control;
    protected String controlName; // reflection

    public Control (By locator){
        this.locator=locator;
    }
    public Control (By locator, String controlName){
        this.locator=locator;
        this.controlName=controlName;
    }

    protected void findControl(){
        control= Session.getInstance().getBrowser().findElement(this.locator);
    }
    @Step("{0}")
    public void step(String action){}
    public void click(){
        this.findControl();
        this.step("Click on "+controlName);
        control.click();
    }

    public boolean isControlDisplayed(){
        try {
            this.findControl();
            this.step("Check the "+controlName+" is displayed: true");
            return control.isDisplayed();
        }catch (Exception e){
            this.step("Check the "+controlName+" is displayed: false");
            return false;
        }
    }
    public void hoverAction(){
        this.findControl();
        Actions action = new Actions(Session.getInstance().getBrowser());
        action.moveToElement(this.control).perform();
    }

    public String getText(){
        this.findControl();
        this.step("Get Text from "+controlName+", the value is: "+control.getText());
        return control.getText();
    }
    public String getAttribute(String value){
        this.findControl();
        return control.getAttribute(value);
    }
    public void waitTextToBe(String text){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(this.locator,text));
    }
    public void waitVisibility(){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.locator));
    }
    public void waitClickable()
    {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(this.locator));
    }
    public void addText(String value){
        this.findControl();
        this.control.sendKeys(value);
    }
    public void waitToElementToBePresent(){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(this.locator));
    }
}

