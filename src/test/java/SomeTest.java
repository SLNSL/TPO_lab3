import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SomeTest {

    static WebDriver driver;
    
    @BeforeAll
    public static void beforeAll(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Test
    @Order(1)
    public void goToTours(){
        driver.manage().window().setSize(new Dimension(1500, 1032));
        driver.get("https://www.tinkoff.ru/travel/tours/");
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@id=\"mainSearchForm\"]/div[3]/div/div[1]/div")).click();
    }

    @Test
    @Order(2)
    public void dateToGo(){

    }
}