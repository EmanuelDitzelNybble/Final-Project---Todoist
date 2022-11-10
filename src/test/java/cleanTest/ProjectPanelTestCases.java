package cleanTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

import java.util.Date;

public class ProjectPanelTestCases extends TestBaseTodoly {
    String project = "New Project";
    String subProject = "SubProject";
    String name = "userName"+ new Date().getTime();
    String email = "userEmail"+ new Date().getTime()+"@gmail.com";
    String pwd = "passwordfield";
    String duplicatedProjectName = "New Project";
    String manyCharactersName = getAlphaNumericString(161);

    @Test
    public void createProject() throws InterruptedException {
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

//    @Test
//    public void editProjectName() throws InterruptedException {
//        presentationPage.signUpButton.waitClickable();
//        presentationPage.signUpButton.click();
//
//        signUpModal.signUp(name, email, pwd);
//        Assertions.assertTrue(navigationBar.logoutButton.isControlDisplayed(), "SignUp Error: User could not register.");
//
//        projectPanel.addNewProjectBtn.waitClickable();
//        projectPanel.addNewProjectBtn.click();
//        projectPanel.newProjectName.waitToElementToBePresent();
//        projectPanel.newProjectName.setText(project);
//        projectPanel.addBtn.click();
//        Assertions.assertTrue(projectPanel.getProject(project).isControlDisplayed(),"Error creating new project");
//
//
//        projectPanel.optionDropDownIcon(project).click();
//        projectPanel.editBtn.click();
//        // Revisar
//        Thread.sleep(2000);
//        projectPanel.getProject(project).addText(" Edited");
//        Thread.sleep(2000);
//        projectPanel.saveChangesBtn.click();
//        Thread.sleep(2000);
//        Assertions.assertEquals(projectPanel.getProject(project).getText(),"New Project Edited", "Error: The project name was not edited"); // REVISAR
//    }

    @Test
    public void duplicatedProjectName() throws InterruptedException {
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
        Assertions.assertFalse(projectPanel.getProject(project).isControlDisplayed(),"Error deleting project");
    }

    @Test
    public void limitOfCharactersProjectName() throws InterruptedException {
        presentationPage.signUpButton.waitClickable();
        presentationPage.signUpButton.click();

        signUpModal.signUp(name, email, pwd);
        Assertions.assertTrue(navigationBar.logoutButton.isControlDisplayed(), "SignUp Error: User could not register.");

        projectPanel.addNewProjectBtn.waitClickable();
        projectPanel.addNewProjectBtn.click();
        projectPanel.newProjectName.waitToElementToBePresent();
        projectPanel.newProjectName.setText(manyCharactersName);
        projectPanel.addBtn.click();
        Assertions.assertTrue(projectPanel.getNumberOfCharacters(manyCharactersName),"Error creating project, too many characters");
    }
}
