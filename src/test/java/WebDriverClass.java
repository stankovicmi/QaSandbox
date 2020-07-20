import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class WebDriverClass {

    protected final WebDriver driver;

    public WebDriverClass() {
        System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator + "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
