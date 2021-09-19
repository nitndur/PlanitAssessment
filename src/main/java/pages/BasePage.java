package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import testBase.BaseTest;
import testBase.DriverFactory;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver){
       this.driver = driver;
   }
    public String GetText(By element){
        return driver.findElement(element).getText();
    }

    public void click(By element){
        waitForElement(element);
        driver.findElement(element).click();
    }

    public void enterText(By element, String text ){
        waitForElement(element);
        driver.findElement(element).sendKeys(text);
    }

    public boolean IsElementDisplayed(By element){
        int numOfElem = driver.findElements(element).size();
        if(numOfElem > 0)
            return true;
        else
            return false;
    }

    public void waitForElement(By element) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(360))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(element);
            }
        });
    }
    public String GetAttributeValue(By element){
        String val = driver.findElement(element).getAttribute("value");
        return val;
    }
}
