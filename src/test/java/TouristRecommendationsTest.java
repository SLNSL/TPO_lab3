// Generated by Selenium IDE
import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class TouristRecommendationsTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    private WebDriverWait wait;
    JavascriptExecutor js;
    
    @After
    public void tearDown() {
        driver.quit();
    }
    public String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }
    @Test
    public void testChrome(){
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testTouristRecommendations();
    }
    
    @Test
    public void testFirefox(){
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testTouristRecommendations();
    }
    
    private void testTouristRecommendations() {
        driver.get("https://www.tinkoff.ru/travel/");
        driver.manage().window().setSize(new Dimension(1552, 840));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[12]/div/div/div/div/h2/p"))
        );
        // Проверяем количество показанных статей
        var articlesNumber = driver.findElements(By.className("ebhtAMbTs")).size();
        Assert.assertEquals(3, articlesNumber);
    }
}