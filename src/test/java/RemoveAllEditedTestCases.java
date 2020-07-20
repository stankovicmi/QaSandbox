import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RemoveAllEditedTestCases extends CommonTest {

    @Test
    public void removeEditedTestCases() throws InterruptedException {
        removeAllEditedTestCases("edited");
    }

    public void removeAllEditedTestCases(String prefix) throws InterruptedException {
        List<WebElement> listOfElements = driver.findElements(By.cssSelector("[href*='/use-cases']"));
        int numberOfCases = listOfElements.size();

        for (int i = 0; i < numberOfCases; ) {
            Thread.sleep(1000);
            boolean isEdited = listOfElements.get(i).getText().contains(prefix + " ");
            Thread.sleep(1000);
            if (isEdited == true) {
                Thread.sleep(1000);
                listOfElements.get(i).click();
                Thread.sleep(1000);
                driver.findElement(By.cssSelector("[aria-label=delete-button]")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
                Thread.sleep(1000);
                listOfElements = driver.findElements(By.cssSelector("[href*='/use-cases']"));
                numberOfCases = numberOfCases - 1;
            } else {
                i++;
            }
        }
    }
}

