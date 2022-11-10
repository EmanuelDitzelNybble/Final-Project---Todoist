package cleanTest;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

import java.util.Date;

public class RecycleBinTests extends TestBaseTodoly {
    @Test
    @DisplayName("Verify that the recycle bin can be emptied.")
    @Description("This test is to verify that a user can empty the recycle bin")
    @Owner("Emanuel Ditzel")
    @Epic("Recycle Bin")
    @Feature("Empty Bin")
    @Story("Recycle Bin Story")
    @Tag("Regression Test")
    public void emptyRecycleBin() throws InterruptedException {
        String project = "New Project";
        String name = "userName"+ new Date().getTime();
        String email = "userEmail"+ new Date().getTime()+"@gmail.com";
        String pwd = "passwordfield";
        String taskName = "Task"+ new Date().getTime();

        presentationPage.signUpButton.waitClickable();
        presentationPage.signUpButton.click();

        signUpModal.signUp(name, email, pwd);
        Assertions.assertTrue(navigationBar.logoutButton.isControlDisplayed(), "SignUp Error: User could not register.");

        projectPanel.addNewProjectBtn.waitClickable();
        projectPanel.addNewProjectBtn.click();
        projectPanel.newProjectName.waitToElementToBePresent();
        projectPanel.newProjectName.setText(project);
        projectPanel.addBtn.click();
        Assertions.assertTrue(projectPanel.getProject(project).isControlDisplayed(),"Error creating new project");

        projectPanel.getProject(project).click();
        taskSection.newItemInput.waitClickable();
        taskSection.newItemInput.setText(taskName);
        taskSection.addItemBtn.click();
        Assertions.assertEquals(taskName, taskSection.getTask(taskName).getText(),"Error trying to create a new task" );

        taskSection.taskCheckbox.check();
        taskSection.getCompletedTask(taskName).waitClickable();
        Assertions.assertTrue(taskSection.getCompletedTask(taskName).isControlDisplayed(),"Error: The task was not moved to the Done section.");

        taskSection.deleteAllBtn.click();
        Session.getInstance().getBrowser().switchTo().alert().accept();
        Thread.sleep(4000);
        Assertions.assertFalse(taskSection.getCompletedTask(taskName).isControlDisplayed(),"Error: The completed task was not deleted");


        recycleBinPanel.recycleBin.click();

        recycleBinPanel.dropDownBtn.click();
        recycleBinPanel.emptyBinBtn.waitClickable();
        recycleBinPanel.emptyBinBtn.click();
        Assertions.assertFalse(taskSection.getCompletedTask(taskName).isControlDisplayed(),"Error: The task has not been deleted");
    }
}
