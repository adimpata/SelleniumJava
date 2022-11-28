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

public class multiSelectNewStyle {

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
        WebElement drpdwn =driver.findElement(By.xpath("//div[contains(@class,'ui') and child::select[@name='skills']]"));
        drpdwn.click();
       // Select select=new Select(drpdowm.findElement(By.name("skills")));
       // select.selectByValue("ruby");

       List<WebElement> drpdwnElements = drpdwn.findElements(By.className("item"));
        drpdwnElements.forEach(v -> System.out.println(v.getText()));
       drpdwn.findElement(By.xpath("//div[@data-value='ruby']")).click();
       drpdwn.findElement(By.xpath("//div[@data-value='ui']")).click();
        drpdwn.findElement(By.xpath("//div[@data-value='ux']")).click();

        System.out.println("=======================================================");

        List<WebElement> selectedDrpdwn=drpdwn.findElements(By.xpath("//i[@class='dropdown icon']/following-sibling::a[@data-value and contains(@class, 'transition')]"));
       selectedDrpdwn.forEach(v -> System.out.println(v.getText()));

        System.out.println("Deselecting");
        selectedDrpdwn.forEach(v ->v.findElement(By.className("delete")).click());





    }
}
