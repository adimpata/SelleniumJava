package dropDowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class oldStyle {

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
            public void testOldStyle(){
    driver.get("https://the-internet.herokuapp.com/dropdown");
    WebElement dropdown= driver.findElement(By.id("dropdown"));

    Select select =new Select(dropdown);

  //  select.selectByValue("2");
     //   System.out.println("by value::" + select.getFirstSelectedOption().getText());

      //  select.selectByVisibleText("Option 1");
       // System.out.println("by visible text::" + select.getFirstSelectedOption().getText());

        select.selectByIndex(0);
        System.out.println("By index::::"+ select.getFirstSelectedOption().getText());

        System.out.println(select.isMultiple());

    }
    }
