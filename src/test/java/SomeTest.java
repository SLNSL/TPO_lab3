import org.asynchttpclient.util.DateUtils;
import org.checkerframework.checker.units.qual.C;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

//        driver.findElement(By.xpath("//*[@id=\"mainSearchForm\"]/div[3]")).click();

        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("//*[@id=\"mainSearchForm\"]/div[3]"))));





//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mainSearchForm\"]/div[3]/div/div[1]/div")));






//        driver.findElement(By.xpath("//*[@id=\"mainSearchForm\"]/div[3]/div/div[1]/div")).click();


    }

    @Test
    @Order(2)
    public void dateToGo(){

    }
}

