package dropDowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class newStyleSingle {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testDropDown() {
        driver.get("https://semantic-ui.com/modules/dropdown.html#/definition");
        WebElement dropdown= driver.findElement(By.xpath("//div[contains(@class,'ui')  and child::input[@name='user']]"));
        dropdown.click();



       List<WebElement> dropdownElements = dropdown.findElements(By.className("item"));
       dropdownElements.forEach(v-> System.out.println(v.getText()));


       dropdown.findElement(By.xpath("//div[@data-value='jenny']")).click();

        System.out.println(dropdown.findElement(By.xpath("//input[@name='user'] ")).getAttribute("value"));
    }
}
