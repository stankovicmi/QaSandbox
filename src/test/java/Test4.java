import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Test4 extends CommonTest {

    @Test
    public void renameEditedCases() throws InterruptedException {
        renameAllTests("edited");
    }

    public void renameAllTests(String prefix) throws InterruptedException {
        List<WebElement> listOfElements = getDriver().findElements(By.cssSelector("[href*='/use-cases']"));
        int numberOfCases = listOfElements.size();

        for (int i = 0; i < numberOfCases; i++) {
            Thread.sleep(1000);
            System.out.println(listOfElements.get(i).getText());
            Thread.sleep(1000);
            listOfElements.get(i).click();
            Thread.sleep(1000);
            renameCase(prefix);
            Thread.sleep(1000);
            listOfElements = getDriver().findElements(By.cssSelector("[href*='/use-cases']"));
        }
    }

    public void renameCase(String prefix) throws InterruptedException {
        String newTitle = prefix + " " + getDriver().findElement(By.cssSelector("input[name='title']")).getAttribute("value");
        Thread.sleep(1000);
        WebElement title = getDriver().findElement(By.cssSelector("input[name='title']"));
        title.clear();
        title.sendKeys(newTitle);
        String newDescription = prefix + " " + getDriver().findElement(By.cssSelector("textarea[name='description']")).getAttribute("value");
        Thread.sleep(1000);
        WebElement description = getDriver().findElement(By.cssSelector("textarea[name='description']"));
        description.clear();
        description.sendKeys(newDescription);
        String newExpectedResult = prefix + " " + getDriver().findElement(By.cssSelector("input[name='expected_result']")).getAttribute("value");
        Thread.sleep(1000);
        WebElement expectedResult = getDriver().findElement(By.cssSelector("input[name='expected_result']"));
        expectedResult.clear();
        expectedResult.sendKeys(newExpectedResult);
        String newCaseStep1 = prefix + " " + getDriver().findElement(By.cssSelector("input[name='testStepId-0']")).getAttribute("value");
        Thread.sleep(1000);
        WebElement caseStep1 = getDriver().findElement(By.cssSelector("input[name='testStepId-0']"));
        Thread.sleep(1000);
        caseStep1.clear();
        caseStep1.sendKeys(newCaseStep1);
        Thread.sleep(1000);
        getDriver().findElement(By.cssSelector("button[type='submit']")).click();
    }
}
