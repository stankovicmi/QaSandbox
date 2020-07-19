import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Test2 extends CommonTest {

    @Test
    public void removeCases() throws InterruptedException {
        removeAllTests();
    }

    public void removeAllTests() throws InterruptedException {
        List<WebElement> listOfElements = getDriver().findElements(By.cssSelector("[href*='/use-cases']"));
        int numberOfCases = listOfElements.size();

        for (int i = 0; i < numberOfCases; ) {
            Thread.sleep(1000);
            System.out.println(listOfElements.get(i).getText());
            Thread.sleep(1000);
            listOfElements.get(i).click();
            Thread.sleep(1000);
            getDriver().findElement(By.cssSelector("[aria-label=delete-button]")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
            Thread.sleep(1000);
            listOfElements = getDriver().findElements(By.cssSelector("[href*='/use-cases']"));
            numberOfCases = numberOfCases - 1;
        }
    }
}
