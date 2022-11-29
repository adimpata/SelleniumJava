package Scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class testBrokenLinksImages {
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
    public void testBrokenImages(){
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> imageList =driver.findElements(By.tagName("img"));
        imageList.forEach(v -> System.out.println(v.getAttribute("src")));
        System.out.println("Total number of link:::"+ imageList.size());
        imageList.forEach(v -> {
            try {
                verifyLinks(v,"src" );
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    @Test
    public void testBrokenLinks(){
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> imageList =driver.findElements(By.tagName("img"));
        System.out.println("Total number of link:::"+ imageList.size());
        imageList.forEach(v -> {
            try {
                verifyLinks(v,"href" );
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    public void  verifyLinks(WebElement element,String attr) throws  IOException,InterruptedException {
        String link = element.getAttribute(attr);
        HttpClient client = HttpClient.newBuilder().build();
        boolean isBroken =false;
        boolean serverError=false;
        if(!(link ==null )){
            HttpRequest request = HttpRequest.newBuilder(URI.create(link)).GET().build();
           HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
            int status =response.statusCode();
            switch (status%100){
                case 4: isBroken =!attr.equals("href") ||status==404;
                break;
                case 5: serverError=true;
                break;
            }
            System.out.println("Link:::::"+link+" :::status::: "+status+" ::::is broken link::::::" +isBroken+" ::::::got server error::::"+serverError);
        }
    }


}
