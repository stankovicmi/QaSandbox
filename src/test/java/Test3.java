import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test3 extends CommonTest {

    @Test
    public void createUseCases() throws InterruptedException {
        createTest("LoginPage - Successful login", "Test if user is able to login successfully.", "User successfully login to the web page", "Enter input (correct) email and password on the respective fields,Click submit button");
        createTest("LoginPage - Unregistered users", "Test if unregistered users is not able to login to the site", "Proper error must be displayed and prompt to enter login again", "Enter input (incorrect) email and password on the respective fields,Click submit button");
        createTest("LoginPage - Empty username and empty password", "Test with empty username and empty password and check if login fails", "Proper error must be displayed and prompt to enter login again", "Enter nothing in the mail and password field,Click submit button");
        createTest("LoginPage - Valid email and empty password", "Test with valid email and empty password such that login must get failed", "Proper error must be displayed and prompt to enter login again", "Enter input (correct) email and empty password on the respective fields,Click submit button");
        createTest("LoginPage - Valid email and incorrect password with less than 6 characters", "Test with valid email and incorrect password with less than 6 characters", "Proper error must be displayed and prompt to enter login again", "Enter input (correct) email and incorrect password with less than 6 characters on the respective fields,Click submit button");
        createTest("LoginPage - Valid email and incorrect password with more than 30 characters", "Test with valid email and incorrect password with more than 100 characters", "Proper error must be displayed and prompt to enter login again", "Enter input (correct) email and incorrect password with more than 100 characters on the respective fields,Click submit button");
    }

    public void createTest(String title, String description, String expectedResult, String caseStep) throws InterruptedException {
        Thread.sleep(1000);
        getDriver().findElement(By.cssSelector("a[href='/create-usecase']")).click();
        Thread.sleep(1000);
        WebElement testTitle = getDriver().findElement(By.cssSelector("input[name='title']"));
        testTitle.sendKeys(title);
        Thread.sleep(1000);
        WebElement testDescription = getDriver().findElement(By.cssSelector("textarea[name='description']"));
        testDescription.sendKeys(description);
        Thread.sleep(1000);
        WebElement testExpectedResult = getDriver().findElement(By.cssSelector("input[name='expected_result']"));
        testExpectedResult.sendKeys(expectedResult);
        Thread.sleep(1000);
        WebElement firstCaseStep = getDriver().findElement(By.cssSelector("input[name='testStepId-0']"));
        firstCaseStep.sendKeys(caseStep);
        Thread.sleep(1000);
        getDriver().findElement(By.cssSelector("button[type='submit']")).click();
        System.out.println("Created test: " + title);
        Thread.sleep(1000);
    }

}
