package Sipacheva;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchMovieFalse extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void SearchMovieFalse() throws Exception {    driver.get(baseUrl + "/php4dvd/");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("q"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("q")).clear();
    driver.findElement(By.id("q")).sendKeys("No");
    driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
    
    WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("#results div.title"))));
    
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("No movies where found.".equals(driver.findElement(By.cssSelector("div.content")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
    
    assertFalse(isElementPresent(By.cssSelector("#results div.title")));

  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
