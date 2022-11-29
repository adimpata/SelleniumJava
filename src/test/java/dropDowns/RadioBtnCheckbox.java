package dropDowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RadioBtnCheckbox {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(enabled = false)
    public void testRadioBtn() {
        driver.get("https://semantic-ui.com/modules/checkbox.html");
        WebElement radioBtn = driver.findElement(By.xpath("//label[contains(text(), 'Once a day') and preceding-sibling::input[@name='example2']]"));
     //   radioBtn.click();
        System.out.println(radioBtn.isSelected());
        Assert.assertTrue(radioBtn.isSelected());



    }

    @Test
    public void testCheckBoxes(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
                WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox' and following-sibling::text()='checkbox 1']"));
        checkBox.click();
        System.out.println(checkBox.isSelected());
        Assert.assertTrue(checkBox.isSelected());
        checkBox.click();

    }
}
