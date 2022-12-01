package Scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class testNewWindow {
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
    public void testWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowH3 = driver.findElement(By.tagName("h3")).getText();
        driver.findElement(By.xpath("//a[text()='Click Here']"));
String parentWindowHandle =driver.getWindowHandle();

//getting the handle of the parent window
        System.out.println(parentWindowH3);
        System.out.println("=============");



        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        //getting the handles/identifiers of all available  windows
        Set<String> windowHandles=driver.getWindowHandles();
        //switching to the child window

        for (String handle :windowHandles){
            if (handle != parentWindowHandle)
                driver.switchTo().window(handle);
        }


        String childWindowH3 = driver.findElement(By.tagName("h3")).getText();
        System.out.println(childWindowH3);
        driver.close();

        System.out.println("switching back to parent window");
        driver.switchTo().window(parentWindowHandle);
        System.out.println(driver.findElement(By.tagName("h3")).getText());



    }
}