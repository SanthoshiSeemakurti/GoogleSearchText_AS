package MVS_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
    static WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
