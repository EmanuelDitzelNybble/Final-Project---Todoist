package todolyPages;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class ProjectPanel {
    public Button addNewProjectBtn = new Button(By.xpath("//td[text()='Add New Project']"),"[Add New Project] button in project panel");
    public Button addBtn = new Button(By.id("NewProjNameButton"),"[Add] button in project panel");
    public TextBox newProjectName = new TextBox(By.id("NewProjNameInput"),"Project Name textBox in project panel");
    public Button optionsDropDownBtn = new Button(By.xpath("//table[@class='ProjItemTable']//td[@class='ItemIndicator']//div[@class='ProjItemMenu' and @itemid='4042058']"), "[Options] drop-down button in project panel");
    public Button editBtn = new Button(By.xpath("//ul[@id=\"projectContextMenu\"]//li[@class=\"edit\"]"), "[Edit] button option in project panel");
    public Button saveChangesBtn = new Button(By.xpath("//td[@class='ProjItemContent UnderEditingItem']//img[@id='ItemEditSubmit']"),"[Save] button in project panel");
    public Button deleteBtn = new Button(By.xpath("//a[@id='ProjShareMenuDel']"),"[Delete] option button in project panel");

    public Boolean getNumberOfCharacters(String string) {
      int numberCount = string.length();
      if (numberCount <= 160) {
          return true;
      } else
          return false;
    }
    public Button optionDropDownIconProject(String name){
        Button optionIconButton = new Button(By.xpath("//li[last()]//td[text()='" + name + "']//following-sibling::td//div[@style=\"display: block;\"]//img[@src=\"/Images/dropdown.png\"]"), "[optionIconButton] in Project Section");
        return optionIconButton;
    }
    public Button getProject(String name) {
        return new Button(By.xpath("//td[@class='ProjItemContent' and text()='"+name+"']"), "Project on project panel");
    }
}
