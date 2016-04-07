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

public class SearchMovieTrue extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void SearchMovieTrue() throws Exception {    driver.get(baseUrl + "/php4dvd/");
  
  WebDriverWait wait = new WebDriverWait(driver, 30); 
  
  By OldElement = By.cssSelector("#results div.movie_cover");
  WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(OldElement));

    WebElement SearchField = driver.findElement(By.id("q"));
	SearchField.clear();
    SearchField.sendKeys("Test_movie");
    SearchField.sendKeys(Keys.ENTER);
      
    wait.until(ExpectedConditions.stalenessOf(element));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#results div.title")));
    assertEquals("Test_movie", driver.findElement(By.cssSelector("#results div.title")).getText());
    
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
