package cleanTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TaskTestCases extends TestBaseTodoly {
    String project = "New Project";
    String name = "userName"+ new Date().getTime();
    String email = "userEmail"+ new Date().getTime()+"@gmail.com";
    String pwd = "passwordfield";
    String taskName = "Task"+ new Date().getTime();

    String manyCharactersName = getAlphaNumericString(260);
        @Test
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
            Thread.sleep(3000);
            Assertions.assertFalse(taskSection.getTask(taskName).isControlDisplayed(),"Error deleting task");
        }

    @Test
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
        public void limitOfCharactersItemName() throws InterruptedException {
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
}