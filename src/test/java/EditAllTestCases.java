import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EditAllTestCases extends CommonTest {

    @Test
    public void editTestCases() throws InterruptedException {
        editAllTestCases("edited");
    }

    public void editAllTestCases(String prefix) throws InterruptedException {
        List<WebElement> listOfElements = driver.findElements(By.cssSelector("[href*='/use-cases']"));
        int numberOfCases = listOfElements.size();

        for (int i = 0; i < numberOfCases; i++) {
            Thread.sleep(1000);
            System.out.println(listOfElements.get(i).getText());
            Thread.sleep(1000);
            listOfElements.get(i).click();
            Thread.sleep(1000);
            renameCase(prefix);
            Thread.sleep(1000);
            listOfElements = driver.findElements(By.cssSelector("[href*='/use-cases']"));
        }
    }

    public void renameCase(String prefix) throws InterruptedException {
        String newTitle = prefix + " " + driver.findElement(By.cssSelector("input[name='title']")).getAttribute("value");
        Thread.sleep(1000);
        WebElement titleWebElement = driver.findElement(By.cssSelector("input[name='title']"));
        titleWebElement.clear();
        titleWebElement.sendKeys(newTitle);
        String newDescription = prefix + " " + driver.findElement(By.cssSelector("textarea[name='description']")).getAttribute("value");
        Thread.sleep(1000);
        WebElement descriptionWebElement = driver.findElement(By.cssSelector("textarea[name='description']"));
        descriptionWebElement.clear();
        descriptionWebElement.sendKeys(newDescription);
        String newExpectedResult = prefix + " " + driver.findElement(By.cssSelector("input[name='expected_result']")).getAttribute("value");
        Thread.sleep(1000);
        WebElement expectedResultWebElement = driver.findElement(By.cssSelector("input[name='expected_result']"));
        expectedResultWebElement.clear();
        expectedResultWebElement.sendKeys(newExpectedResult);
        String newFirstCaseStep = prefix + " " + driver.findElement(By.cssSelector("input[name='testStepId-0']")).getAttribute("value");
        Thread.sleep(1000);
        WebElement firstCaseStepWebElement = driver.findElement(By.cssSelector("input[name='testStepId-0']"));
        Thread.sleep(1000);
        firstCaseStepWebElement.clear();
        firstCaseStepWebElement.sendKeys(newFirstCaseStep);
        Thread.sleep(1000);
        String newSecondCaseStep = prefix + " " + driver.findElement(By.cssSelector("input[name='testStepId-1']")).getAttribute("value");
        Thread.sleep(1000);
        WebElement secondCaseStepWebElement = driver.findElement(By.cssSelector("input[name='testStepId-1']"));
        Thread.sleep(1000);
        secondCaseStepWebElement.clear();
        secondCaseStepWebElement.sendKeys(newSecondCaseStep);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
