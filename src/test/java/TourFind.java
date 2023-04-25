// Generated by Selenium IDE
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;
public class TourFind {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    driver.manage().window().maximize();
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
  public void test() {
    // Test name: Поиск Туров
    // Step # | name | target | value | comment
    // 1 | open | https://www.tinkoff.ru/travel/ |  | 
    driver.get("https://www.tinkoff.ru/travel/");
    // 3 | click | xpath=//li[3]/div/a/span/div |  | 
    driver.findElement(By.xpath("//li[3]/div/a/span/div")).click();
    // 5 | selectFrame | index=0 |  | 
    driver.switchTo().frame(0);
    // 6 | click | xpath=//form[@id='mainSearchForm']/div/div/div/div/a |  | 
    driver.findElement(By.xpath("//form[@id=\'mainSearchForm\']/div/div/div/div/a")).click();
    // 7 | click | xpath=//form[@id='mainSearchForm']/div/div/div[2]/div/div |  | 
    driver.findElement(By.xpath("//form[@id=\'mainSearchForm\']/div/div/div[2]/div/div")).click();
    // 9 | click | xpath=//form[@id='mainSearchForm']/div[2]/div/div/div/input |  | 
    driver.findElement(By.xpath("//form[@id=\'mainSearchForm\']/div[2]/div/div/div/input")).click();
    // 10 | click | xpath=//form[@id='mainSearchForm']/div[2]/div/div[2]/ul/li/label/div |  | 
    driver.findElement(By.xpath("//form[@id=\'mainSearchForm\']/div[2]/div/div[2]/ul/li/label/div")).click();
    // 11 | click | xpath=//form[@id='mainSearchForm']/div[2]/div/div[2]/ul/li[5]/label/div/div |  | 
    driver.findElement(By.xpath("//form[@id=\'mainSearchForm\']/div[2]/div/div[2]/ul/li[5]/label/div/div")).click();
    // 13 | click | css=.formDropdownWithCalendar .formInputPlace |  | 
    driver.findElement(By.cssSelector(".formDropdownWithCalendar .formInputPlace")).click();
    // 14 | executeScript | return document.querySelector('.ui-corner-right .ui-datepicker-month').textContent + document.querySelector('.ui-corner-right .ui-datepicker-year').textContent | data | 
    vars.put("data", js.executeScript("return document.querySelector(\'.ui-corner-right .ui-datepicker-month\').textContent + document.querySelector(\'.ui-corner-right .ui-datepicker-year\').textContent"));
    // 15 | while | ${data} != "Май2023" |  | 
    while ((Boolean) js.executeScript("return (arguments[0] != \'Май2023\')", vars.get("data"))) {
      // 16 | click | xpath=//div[@id='dateRangeContainer']/div/div/div/a/span |  | 
      driver.findElement(By.xpath("//div[@id=\'dateRangeContainer\']/div/div/div/a/span")).click();
      // 17 | executeScript | return document.querySelector('.ui-corner-right .ui-datepicker-month').textContent + document.querySelector('.ui-corner-right .ui-datepicker-year').textContent | data | 
      vars.put("data", js.executeScript("return document.querySelector(\'.ui-corner-right .ui-datepicker-month\').textContent + document.querySelector(\'.ui-corner-right .ui-datepicker-year\').textContent"));
      // 18 | end |  |  | 
    }
    // 19 | click | xpath=//div[@id='dateRangeContainer']/div/div[2]/table/tbody/tr[2]/td[2]/a |  | 
    driver.findElement(By.xpath("//div[@id=\'dateRangeContainer\']/div/div[2]/table/tbody/tr[2]/td[2]/a")).click();
    // 22 | executeScript | return document.querySelector('.tour-duration-from').value | min_pers | 
    vars.put("min_pers", js.executeScript("return document.querySelector(\'.tour-duration-from\').value"));
    // 23 | while | ${min_pers} > 2 |  | 
    while ((Boolean) js.executeScript("return (arguments[0] > 2)", vars.get("min_pers"))) {
      // 24 | click | xpath=//form[@id='mainSearchForm']/div[4]/div/div[2]/div/div/div/span/a[2] |  | 
      driver.findElement(By.xpath("//form[@id=\'mainSearchForm\']/div[4]/div/div[2]/div/div/div/span/a[2]")).click();
      // 25 | executeScript | return document.querySelector('.tour-duration-from').value | min_pers | 
      vars.put("min_pers", js.executeScript("return document.querySelector(\'.tour-duration-from\').value"));
      // 26 | end |  |  | 
    }
    // 27 | while | ${min_pers} < 2 |  | 
    while ((Boolean) js.executeScript("return (arguments[0] < 2)", vars.get("min_pers"))) {
      // 28 | click | xpath=//form[@id='mainSearchForm']/div[4]/div/div[2]/div/div/div/span/a |  | 
      driver.findElement(By.xpath("//form[@id=\'mainSearchForm\']/div[4]/div/div[2]/div/div/div/span/a")).click();
      // 29 | executeScript | return document.querySelector('.tour-duration-from').value | min_pers | 
      vars.put("min_pers", js.executeScript("return document.querySelector(\'.tour-duration-from\').value"));
      // 30 | end |  |  | 
    }
    // 32 | executeScript | return document.querySelector('.tour-duration-to').value | max_pers | 
    vars.put("max_pers", js.executeScript("return document.querySelector(\'.tour-duration-to\').value"));
    // 33 | while | ${max_pers} > 7 |  | 
    while ((Boolean) js.executeScript("return (arguments[0] > 7)", vars.get("max_pers"))) {
      // 34 | click | xpath=//form[@id='mainSearchForm']/div[4]/div/div[2]/div/div[2]/div/span/a[2] |  | 
      driver.findElement(By.xpath("//form[@id=\'mainSearchForm\']/div[4]/div/div[2]/div/div[2]/div/span/a[2]")).click();
      // 35 | executeScript | return document.querySelector('.tour-duration-to').value | max_pers | 
      vars.put("max_pers", js.executeScript("return document.querySelector(\'.tour-duration-to\').value"));
      // 36 | end |  |  | 
    }
    // 37 | while | ${max_pers} < 7 |  | 
    while ((Boolean) js.executeScript("return (arguments[0] < 7)", vars.get("max_pers"))) {
      // 38 | click | xpath=//form[@id='mainSearchForm']/div[4]/div/div[2]/div/div[2]/div/span/a |  | 
      driver.findElement(By.xpath("//form[@id=\'mainSearchForm\']/div[4]/div/div[2]/div/div[2]/div/span/a")).click();
      // 39 | executeScript | return document.querySelector('.tour-duration-to').value | max_pers | 
      vars.put("max_pers", js.executeScript("return document.querySelector(\'.tour-duration-to\').value"));
      // 40 | end |  |  | 
    }
    // 42 | click | xpath=//form[@id='mainSearchForm']/div[5]/div/div/div |  | 
    driver.findElement(By.xpath("//form[@id=\'mainSearchForm\']/div[5]/div/div/div")).click();
    // 43 | click | xpath=//form[@id='mainSearchForm']/div[5]/div/div[2]/div/div/div[2]/div/label |  | 
    driver.findElement(By.xpath("//form[@id=\'mainSearchForm\']/div[5]/div/div[2]/div/div/div[2]/div/label")).click();
    // 45 | click | xpath=//div[6]/div |  | 
    vars.put("window_handles", driver.getWindowHandles());
    // 46 | selectWindow | handle=${win4010} |  | 
    driver.findElement(By.xpath("//div[6]/div")).click();
    vars.put("win4010", waitForWindow(2000));
    driver.switchTo().window(vars.get("win4010").toString());
  }
}