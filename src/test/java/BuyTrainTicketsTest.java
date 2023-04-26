import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BuyTrainTicketsTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    private WebDriverWait wait;

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testChrome(){
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        test();
    }

    @Test
    public void testFirefox(){
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        test();
    }

    private void test() {
        driver.get("https://www.tinkoff.ru/travel/trains/");
        driver.manage().window().setSize(new Dimension(1552, 840));
        driver.switchTo().frame(0);
        // откуда
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@name=\'fromText\']"))
        ).sendKeys("Краснодар");
        // куда
        driver.findElement(By.xpath("//input[@name=\'toText\']")).sendKeys("Москва");
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[2]/div/div/span"))
        ).click();
        driver.findElement(By.xpath("//form[@id=\'RailwaysSearchForm\']/div[6]/button")).click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//input[@type=\'checkbox\'])[4]"))
        ).click();
        driver.findElement(By.xpath("//div[@id=\'railways-search-page\']/div[2]/div/div/div[3]/div/div/div[2]/div[2]/div[2]/div/div[2]/div/button/div/span")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//form[@id=\'seatSelectionForm\']/div[3]/div/div/div[2]/div[3]/div[2]/div[3]/button/div"))
        ).click();
        // выбор места
        //driver.findElement(By.xpath("//form[@id=\'seatSelectionForm\']/div[3]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[2]/div/div/div/div[44]/span/div")).click();
        driver.findElement(By.cssSelector(".SeatSelection-Scheme-Seat-Seat__Seat:not(.SeatSelection-Scheme-Seat-Seat__taken).SeatSelection-Scheme-Seat-Seat__isSeat")).click();
        driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
        
        String departureTime = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@id='railways-passengers-page']/div/div/div/div/div/div/div/div/div[3]/div/div/time/span"))
        ).getText().substring(0, 2);

        Assert.assertTrue(Integer.parseInt(departureTime) <= 5);
    }
}