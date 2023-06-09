// Generated by Selenium IDE
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
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
public class SeeOtherCardsTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    private WebDriverWait wait;
    private final String creditCardName = "Кукуруза";
    private final String debitCardName = "Tinkoff Junior";
    JavascriptExecutor js;
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
        testOtherCards();
    }

    @Test
    public void testFirefox(){
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        testOtherCards();
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
    private void testOtherCards() {
        driver.get("https://www.tinkoff.ru/travel/");
        driver.manage().window().setSize(new Dimension(1552, 840));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button/div[2]"))
        ).click();
        driver.findElement(By.xpath("//button[2]")).click();
        // Ищем кредитную карту
        var foundCard = (Boolean) js.executeScript("return !!Array.from(\n" +
                "    document.querySelectorAll('.FullCard__name_hMUip')\n" +
                ").map(el => el.innerText)\n" +
                ".find(name => name === '" + creditCardName + "')");
        Assert.assertTrue(foundCard);
        
        driver.findElement(By.xpath("//button[3]")).click();
        // Ищем дебетовую карту
        foundCard = (Boolean) js.executeScript("return !!Array.from(\n" +
                "    document.querySelectorAll('.FullCard__name_hMUip')\n" +
                ").map(el => el.innerText)\n" +
                ".find(name => name === '" + debitCardName + "')");
        Assert.assertTrue(foundCard);
        
        driver.findElement(By.xpath("(//input[@type=\'checkbox\'])[2]")).click();
        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/input")).click();
        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/input")).sendKeys("Tinkoff Black");
        // Проверяем, что есть 3 карты Тинкофф Black
        var foundCards = (Boolean) js.executeScript("""
                return Array.from(
                    document.querySelectorAll('.FullCard__name_hMUip')
                ).length === 3""");
        Assert.assertTrue(foundCards);
        
        driver.findElement(By.xpath("//div[4]/div/div/div[2]/div[2]")).click();
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.xpath("//div[2]/div[2]/a/span")).click();
        vars.put("win9023", waitForWindow(2000));
        driver.switchTo().window(vars.get("win9023").toString());
        Assert.assertEquals(
                "https://www.tinkoff.ru/travel/help/travel/planetickets/about/avia-cashback/?card=tinkoff-pro",
                driver.getCurrentUrl()
        );
    }
}