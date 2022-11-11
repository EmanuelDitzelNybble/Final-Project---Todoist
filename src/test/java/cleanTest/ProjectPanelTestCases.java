package cleanTest;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

import java.util.Date;

public class ProjectPanelTestCases extends TestBaseTodoly {
    String project = "New Project";
    String name = "userName"+ new Date().getTime();
    String email = "userEmail"+ new Date().getTime()+"@gmail.com";
    String pwd = "passwordfield";
    String duplicatedProjectName = "New Project";
    String manyCharactersName = getAlphaNumericString(161);

    @Test
    @DisplayName("Verify that a project can be created")
    @Description("This test is to verify that a user can create a new project")
    @Owner("Emanuel Ditzel")
    @Epic("Projects")
    @Feature("Create Project")
    @Story("Project Story")
    @Tag("ProjectTests")
    @Severity(SeverityLevel.CRITICAL)
    public void createProject() {
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
    }

    @Test
    @DisplayName("Verify that a user cannot create two projects with the same name")
    @Description("This test case is to verify that a user cannot create a project with a name that already exists.")
    @Owner("Emanuel Ditzel")
    @Epic("Projects")
    @Feature("Duplicated Project")
    @Story("Project Story")
    @Tag("Bug")
    @Severity(SeverityLevel.NORMAL)
    public void duplicatedProjectName() {
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

        String name = projectPanel.getProject(project).getText();
        projectPanel.addNewProjectBtn.waitClickable();
        projectPanel.addNewProjectBtn.click();
        projectPanel.newProjectName.waitToElementToBePresent();
        projectPanel.newProjectName.setText(duplicatedProjectName);
        projectPanel.addBtn.click();
        String duplicatedName = projectPanel.getProject(duplicatedProjectName).getText();
        Assertions.assertNotEquals(name, duplicatedName, "Error: Project with the entered name already exists");
    }

    @Test
    @DisplayName("Verify that a user can delete a project ")
    @Description("This test is to verify if a user can delete a created project")
    @Owner("Emanuel Ditzel")
    @Epic("Projects")
    @Feature("Delete Project")
    @Story("Project Story")
    @Tag("ProjectTests")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteProject() throws InterruptedException {
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
        projectPanel.optionDropDownIconProject(project).click();
        projectPanel.deleteBtn.waitClickable();
        projectPanel.deleteBtn.click();
        Session.getInstance().getBrowser().switchTo().alert().accept();
        Thread.sleep(3000);
        Assertions.assertFalse(projectPanel.getProject(project).isControlDisplayed(),"Error deleting project");
    }

    @Test
    @DisplayName("Verify that a project name with more than 160 characters cannot be created")
    @Description("This test case is to verify that the creation of a new project has a character limit in the name input.")
    @Owner("Emanuel Ditzel")
    @Epic("Projects")
    @Feature("Limit Of Characters in Project Name")
    @Story("Project Story")
    @Tag("Bugs")
    @Severity(SeverityLevel.NORMAL)
    public void limitOfCharactersProjectName() {
        presentationPage.signUpButton.waitClickable();
        presentationPage.signUpButton.click();

        signUpModal.signUp(name, email, pwd);
        Assertions.assertTrue(navigationBar.logoutButton.isControlDisplayed(), "SignUp Error: User could not register.");

        projectPanel.addNewProjectBtn.waitClickable();
        projectPanel.addNewProjectBtn.click();
        projectPanel.newProjectName.waitToElementToBePresent();
        projectPanel.newProjectName.setText(manyCharactersName);
        projectPanel.addBtn.click();
        Assertions.assertTrue(projectPanel.verifyStringNoLongerThan(manyCharactersName, 160),"Error creating project, too many characters");
    }
}
