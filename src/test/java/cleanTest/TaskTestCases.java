package cleanTest;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

import java.util.Date;

public class TaskTestCases extends TestBaseTodoly {
    String project = "New Project";
    String name = "userName"+ new Date().getTime();
    String email = "userEmail"+ new Date().getTime()+"@gmail.com";
    String pwd = "passwordfield";
    String taskName = "Task"+ new Date().getTime();
    String taskName1 = "Changing to Priority 2";
    String manyCharactersName = getAlphaNumericString(260);
    @Test
    @DisplayName("Verify that a user can create a new task")
    @Description("This test is to verify that a task can be created successfully by the user")
    @Owner("Emanuel Ditzel")
    @Epic("Task")
    @Feature("Create Task")
    @Story("Task Story")
    @Tag("Regression Test")
        public void createTask() throws InterruptedException {

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
        }
    @Test
    @DisplayName("Verify that a user can delete a task")
    @Description("This test is to verify that a user can delete a task created before")
    @Owner("Emanuel Ditzel")
    @Epic("Task")
    @Feature("Delete Task")
    @Story("Task Story")
    @Tag("Regression Test")
        public void deleteTask() throws InterruptedException {
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

            taskSection.getTask(taskName).click();
            taskSection.optionTaskBtn.click();
            taskSection.deleteTaskBtn.waitClickable();
            taskSection.deleteTaskBtn.click();
            Assertions.assertTrue(taskSection.itemDeletedValidationMessage.isControlDisplayed(),"Error deleting task");
        }

    @Test
    @DisplayName("Verify that the hidden/shown button is working properly")
    @Description("This test is to verify that the hidden/shown button works properly.")
    @Owner("Emanuel Ditzel")
    @Epic("Task")
    @Feature("Hide and Show task")
    @Story("Task Story")
    @Tag("Regression Test")
    @Severity(SeverityLevel.MINOR)
        public void hiddenAndShownButtonsFunctionality() throws InterruptedException {
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

        taskSection.hiddenButton.click();
        taskSection.shownNotesButton.isControlDisplayed();
        taskSection.shownNotesButton.click();
        Assertions.assertFalse(taskSection.getTask(taskName).isControlDisplayed(),"Error: task is still displayed");
    }

    @Test
    @DisplayName("Verify that a user can set the priority to a task")
    @Description("This test case is to verify if a user can set a priority to a specific task")
    @Owner("Emanuel Ditzel")
    @Epic("Task")
    @Feature("Set Task Priority")
    @Story("Task Story")
    @Tag("Regression Test")
        public void setPriority() throws InterruptedException {
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

            taskSection.getTask(taskName).click();
            taskSection.optionTaskBtn.click();
            taskSection.selectPriority(2).click();
            String expectedItemTextColor = "background-color: rgb(22, 139, 184);";
            String actualItemTextColor = taskSection.priorityTwoOption.getAttribute("style");
            Assertions.assertEquals(actualItemTextColor, expectedItemTextColor,"Error: the selected priority is not priority 2.");
        }
    @Test
    @DisplayName("Verify that a task with more than 250 characters cannot be created")
    @Description("This test is to verify that there is a character limit when creating a new task.")
    @Owner("Emanuel Ditzel")
    @Epic("Task")
    @Feature("Limit Of Characters in Task Name")
    @Story("Task Story")
    @Tag("Regression Test")
    @Severity(SeverityLevel.BLOCKER)
        public void limitOfCharactersTaskName() throws InterruptedException {
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
            taskSection.newItemInput.setText(manyCharactersName);
            taskSection.addItemBtn.click();
            Assertions.assertTrue(taskSection.getNumberOfCharacters(manyCharactersName),"Error: Error creating task, too many characters");
        }

    @Test
    @DisplayName("Verify if a user can mark a task as Done")
    @Description("This test is to verify that a user can set a task as done")
    @Owner("Emanuel Ditzel")
    @Epic("Task")
    @Feature("Complete a Task")
    @Story("Task Story")
    @Tag("Regression Test")
        public void verifyCompletedTask() throws InterruptedException {
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
            Assertions.assertTrue(taskSection.getCompletedTask(taskName).isControlDisplayed(),"Error: The task was not deleted");
        }

    @Test
    @DisplayName("Verify that completed items can be deleted")
    @Description("This test is to verify that a user can delete a task that is already done")
    @Owner("Emanuel Ditzel")
    @Epic("Task")
    @Feature("Task Removal")
    @Story("Task Story")
    @Tag("Regression Test")
        public void deleteCompletedTask() throws InterruptedException {
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
            //navigationBar.logoutButton.waitClickable();
            Thread.sleep(4000);
            Assertions.assertFalse(taskSection.getCompletedTask(taskName).isControlDisplayed(),"Error: The completed task was not deleted");
        }
}