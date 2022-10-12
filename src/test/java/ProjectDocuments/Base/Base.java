package ProjectDocuments.Base;

import ProjectDocuments.Driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Base {
    private static final Logger logger = LogManager.getLogger(Base.class);
    WebDriver driver;
    FluentWait<WebDriver> fluentWait;
    JavascriptExecutor jsDriver;
    public Base() {

        this.driver = Driver.driver;
        jsDriver = (JavascriptExecutor) driver;
        fluentWait = setFluentWait(30);
    }
    public FluentWait<WebDriver> setFluentWait(long timeout) {

        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement findElement(By by) {

        return driver.findElement(by);
    }

    public WebElement findElementWait(By by) {

        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void clickElement(By by) {

        findElementWait(by).click();
    }

    public String getText(By by) {

        return findElementWait(by).getText();
    }
    public void hoverElement(By by) {

        WebElement webElement = findElementWait(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
        logger.info(by.toString() + "hovered ");
    }
    public void scrollElement(By by) {
        WebElement webElement = findElementWait(by);
        jsDriver.executeScript("arguments[0].scrollIntoView()", webElement);
    }
    public void waitBySeconds(long Seconds) {
        logger.info(Seconds + " seconds waited ");
    }
    public Boolean isDisplayed(By by) {
        return findElement(by).isDisplayed();
    }
}
