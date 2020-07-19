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
        WebElement email = getDriver().findElement(By.cssSelector("input[type='email']"));
        WebElement password = getDriver().findElement(By.cssSelector("input[type='password']"));
        WebElement submit = getDriver().findElement(By.cssSelector("button[type='submit']"));
        email.sendKeys(EMAIL);
        password.sendKeys(PASSWORD);
        submit.click();
        Thread.sleep(1000);
        getDriver().findElement(By.cssSelector("a[href='/use-cases']")).click();
        Thread.sleep(1000);
    }

    @After
    public void quit() {
        getDriver().quit();
    }
}
