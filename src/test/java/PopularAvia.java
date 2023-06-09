// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class PopularAvia {
    private WebDriver driver;
    private Map<String, Object> vars;
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
        test();
    }

    @Test
    public void testFirefox(){
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        test();
    }

    private void test() {
        driver.get("https://www.tinkoff.ru/travel/flights/");
        vars.put("from", js.executeScript("return document.evaluate(\"//div[12]/div/div/div/div/div/div/a/span\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.textContent.split(\'—\')[0]"));
        vars.put("to", js.executeScript("return document.evaluate(\"//div[12]/div/div/div/div/div/div/a/span\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.textContent.split(\'—\')[1]"));
        driver.findElement(By.xpath("//div[12]/div/div/div/div/div/div/a/span")).click();
        driver.findElement(By.xpath("//div[2]/button/span")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[3]/div[2]/div[3]/div/div/div/div/div[1]/div[1]/div/div[2]/h2")));
        }
        vars.put("curfrom", js.executeScript("return document.evaluate(\"/html/body/div[1]/div/div/div[3]/div[2]/div[3]/div/div/div/div/div[1]/div[1]/div/div[2]/h2\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.textContent.split(\'–\')[0]"));
        vars.put("curto", js.executeScript("return document.evaluate(\"/html/body/div[1]/div/div/div[3]/div[2]/div[3]/div/div/div/div/div[1]/div[1]/div/div[2]/h2\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.textContent.split(\'–\')[1]"));
        assertEquals(vars.get("curfrom").toString().split(" ")[0].trim(), vars.get("from").toString().split(" ")[0].trim());
        assertEquals(vars.get("curto").toString().split(" ")[0].trim(), vars.get("to").toString().split(" ")[0].trim());
    }
}