import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.SocketException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BuyTrainTicketsTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    private WebDriverWait wait;
    
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        vars = new HashMap<String, Object>();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() throws SocketException{
        try {
            driver.quit();
        }catch (Exception e){
            // do nothing
        }
    }

    @Test
    public void test() {
        driver.get("https://www.tinkoff.ru/travel/trains/");
        driver.manage().window().setSize(new Dimension(1552, 840));
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@name=\'fromText\']"))
        ).sendKeys("Краснодар");
        driver.findElement(By.xpath("//input[@name=\'toText\']")).sendKeys("Москва");
        driver.findElement(By.xpath("//div[2]/div/div/span")).click();
        driver.findElement(By.xpath("//form[@id=\'RailwaysSearchForm\']/div[6]/button")).click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//input[@type=\'checkbox\'])[4]"))
        ).click();
        driver.findElement(By.xpath("//div[@id=\'railways-search-page\']/div[2]/div/div/div[3]/div/div/div[2]/div[2]/div[2]/div/div[2]/div/button/div/span")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//form[@id=\'seatSelectionForm\']/div[3]/div/div/div[2]/div[3]/div[2]/div[3]/button/div"))
        ).click();
        //driver.findElement(By.xpath("//form[@id=\'seatSelectionForm\']/div[3]/div/div/div[2]/div[3]/div[2]/div[3]/button/div")).click();
        driver.findElement(By.xpath("//form[@id=\'seatSelectionForm\']/div[3]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[2]/div/div/div/div[44]/span/div")).click();
        //driver.findElement(By.xpath("//form[@id=\'seatSelectionForm\']/div[3]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[2]/div/div/div/div[22]/span/div")).click();
        driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
    }
}