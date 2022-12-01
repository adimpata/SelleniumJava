package Scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SeleniumScreenshot {
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
    public void testShot() {
        driver.get("https://semantic-ui.com/modules/dropdown.html#/definition");
/*
        //declarare  screen si tipul
        TakesScreenshot shot =(TakesScreenshot) driver;
        //preluare screenshot ca un fisier a  unui obiect

        File fl=shot.getScreenshotAs(OutputType.FILE);

        //realizarea fisierului de copiat

        File dfl= new File("screenshot1.jpg");
        try {
            FileUtils.copyFile(fl, dfl);
        } catch (IOException e){
            e.printStackTrace();
        }
*/

        File fl2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   try {
       FileUtils.copyFile(fl2,new File("screenshotCopy.jpg"));
   } catch (IOException e){
       e.printStackTrace();
   }

    }
}
