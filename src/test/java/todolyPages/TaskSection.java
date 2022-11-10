package todolyPages;

import controlSelenium.Button;
import controlSelenium.Control;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class TaskSection {
    public TextBox newItemInput = new TextBox(By.id("NewItemContentInput"),"[Add New Item] in task section");
    public Button addItemBtn = new Button(By.id("NewItemAddButton"),"[Add] button in task section");
    public Button deleteTaskBtn = new Button(By.xpath("//li[last()]/a[text()='Delete']"),"[Delete] button in task section");
    public Button optionTaskBtn = new Button(By.xpath("//div[@id=\"ItemListPlaceHolder\"]//img[@src=\"/Images/dropdown.png\"]"),"[Option] icon button in task section");
    public Button priorityTwoOption = new Button(By.xpath("//div[@id=\"Div1\"]//span[@iconid=\"2\"]"),"[Priority 2] in task section");
    public Button shownNotesButton = new Button(By.xpath("//span[@id='NotesAllText']"),"[Shown] button in task section");
    public Button hiddenButton = new Button(By.xpath("//span[@id='NotesAllText']"),"[Hidden] button in task section");

    public Button getTask(String name) {
        return new Button(By.xpath("//ul[@id=\"mainItemList\"]//div[text()='" +name+ "']"), "[Task] created in task section]");
    }
    public Button selectPriority(int priorityByNumber) {
        return new Button(By.xpath("//div[@id=\"Div1\"]//span[@iconid='"+priorityByNumber+"']"),"[Priority] number '"+priorityByNumber+"' in task section");
    }
    public Boolean getNumberOfCharacters(String string) {
        int numberCount = string.length();
        if (numberCount <= 250) {
            return true;
        } else
            return false;
    }

    public Button optionDropDownIconTask(String name){
        Button optionIconButton = new Button(By.xpath("//li[last()]//td[text()='" + name + "']//following-sibling::td//div[@style=\"display: block;\"]//img[@src=\"/Images/dropdown.png\"]"), "[optionIconButton] in Project Section");
        return optionIconButton;
    }
}
