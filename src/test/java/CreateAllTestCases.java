import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateAllTestCases extends CommonTest {

    @Test
    public void createAllTestCases() throws InterruptedException {
        createTestCase("LoginPage - Successful login", "Test login page if user is able to login successfully.", "User successfully login to the web page", "Enter input (correct) email and password on the respective fields,Click submit button");
        createTestCase("LoginPage - Unregistered users", "Test login page if unregistered users is not able to login to the site", "Proper error must be displayed and prompt to enter login again", "Enter input (incorrect) email and password on the respective fields,Click submit button");
        createTestCase("LoginPage - Empty username and empty password", "Test login page with empty username and empty password and check if login fails", "Proper error must be displayed and prompt to enter login again", "Enter nothing in the mail and password field,Click submit button");
        createTestCase("LoginPage - Valid email and empty password", "Test login page with valid email and empty password such that login must get failed", "Proper error must be displayed and prompt to enter login again", "Enter input (correct) email and empty password on the respective fields,Click submit button");
        createTestCase("LoginPage - Valid email and incorrect password with less than 6 characters", "Test login page with valid email and incorrect password with less than 6 characters", "Proper error must be displayed and prompt to enter login again", "Enter input (correct) email and incorrect password with less than 6 characters on the respective fields,Click submit button");
        createTestCase("LoginPage - Valid email and incorrect password with more than 30 characters", "Test login page with valid email and incorrect password with more than 30 characters", "Proper error must be displayed and prompt to enter login again", "Enter input (correct) email and incorrect password with more than 30 characters on the respective fields,Click submit button");
    }

    public void createTestCase(String title, String description, String expectedResult, String caseStep) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='/create-usecase']")).click();
        Thread.sleep(1000);
        WebElement titleWebElement = driver.findElement(By.cssSelector("input[name='title']"));
        titleWebElement.sendKeys(title);
        Thread.sleep(1000);
        WebElement descriptionWebElement = driver.findElement(By.cssSelector("textarea[name='description']"));
        descriptionWebElement.sendKeys(description);
        Thread.sleep(1000);
        WebElement expectedResultWebElement = driver.findElement(By.cssSelector("input[name='expected_result']"));
        expectedResultWebElement.sendKeys(expectedResult);
        Thread.sleep(1000);
        WebElement caseStepWebElement = driver.findElement(By.cssSelector("input[name='testStepId-0']"));
        caseStepWebElement.sendKeys(caseStep);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        System.out.println("Created test: " + title);
        Thread.sleep(1000);
    }
}
