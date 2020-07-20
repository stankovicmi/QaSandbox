import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonTest extends WebDriverClass {

    private final String EMAIL = "stankovicmih@gmail.com";
    private final String PASSWORD = "Test!12345";

    @Before
    public void login() throws InterruptedException {
        driver.get("https://qa-sandbox.apps.htec.rs/login");
        WebElement emailWebElement = driver.findElement(By.cssSelector("input[type='email']"));
        emailWebElement.sendKeys(EMAIL);
        WebElement passwordWebElement = driver.findElement(By.cssSelector("input[type='password']"));
        passwordWebElement.sendKeys(PASSWORD);
        WebElement submitWebElement = driver.findElement(By.cssSelector("button[type='submit']"));
        submitWebElement.click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='/use-cases']")).click();
        Thread.sleep(1000);
    }

    @After
    public void quit() {

        driver.quit();
    }
}
