package MVS_Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

// search for "Active sync" using Selenium in Google.
// Then the first link should be clicked.

public class Main {

    public static void main(String args[]) throws InterruptedException {
        Base.getDriver();
        WebDriver driver = new ChromeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //URL launch
        driver.get("https://www.google.com/");
        WebElement rejectAll = driver.findElement(By.id("W0wltc"));
        rejectAll.click();
        //identify element
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Active sync");
        Thread.sleep(1000);
        // finding suggestion list
        List<WebElement> suggestion_list = driver.findElements(By.xpath("//cr-realbox-match/[@role='option']/descendant::div[@id='contents']"));
        System.out.println(suggestion_list.size());
        Thread.sleep(1000);
        for (WebElement suggestion_name : suggestion_list) {
            String suggestion_value = suggestion_name.getText();
            System.out.println(suggestion_value);
            // selecting the link "Active sync"
            if (suggestion_value.equalsIgnoreCase("Active sync")) {
                suggestion_name.click();
            }
        }
    }
}