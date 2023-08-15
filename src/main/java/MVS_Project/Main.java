package MVS_Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

// search for "Active sync" using Selenium in Google.
// Then the first link should be clicked.

public class Main {

    public static void main(String args[]) throws InterruptedException {
        Base.getDriver();
        WebDriver driver = new ChromeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //URL launch
        driver.get("https://www.google.com/");
        WebElement rejectAll = driver.findElement(By.id("W0wltc"));
        rejectAll.click();
        //identify element
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Active sync");
        Thread.sleep(1000);
        // finding suggestion list
        List<WebElement> suggestion_list = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        System.out.println("Size of the suggestion list: " + suggestion_list.size());
        // clicking the first link from the suggestions list
        suggestion_list.get(0).click();
    }
}