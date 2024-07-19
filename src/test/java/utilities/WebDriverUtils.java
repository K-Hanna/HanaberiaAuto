package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class WebDriverUtils extends BaseTest{

    public static void waitForPageToLoad(){
        ExpectedCondition<Boolean> expectation = webDriver -> ((JavascriptExecutor) Objects.requireNonNull(webDriver))
                .executeScript("return document.readyState").toString().equals("complete");
        try{
            explicitWait.until(expectation);
        } catch (Throwable error){
            Assert.fail();
        }
    }

    public static void waitForElementToBeVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waiting(int milis){
        try{
            Thread.sleep(milis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void elementShouldBeVisible(WebElement element){
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void elementShouldBeClickable(WebElement element){
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static List<WebElement> getListOfElements(By locator){
        List<WebElement> elements;
        try {
            elements = driver.findElements(locator);
        } catch (StaleElementReferenceException e){
            driver.navigate().refresh();
            elements = driver.findElements(locator);
        }
        return elements;
    }

    public static void click(WebElement element){
        elementShouldBeVisible(element);
        elementShouldBeClickable(element);
        element.click();
    }

    public static String getScr(WebElement element){
        return element.getAttribute("src");
    }

    public static String getAttribute(WebElement element, By locator, String attribute){
        WebElement element1 = element.findElement(locator);
        return element1.getAttribute(attribute);
    }

    public static String getTextFromElement(WebElement element){
        elementShouldBeVisible(element);
        return element.getText();
    }

    public static WebElement getChild(By locator, By locator1){
        WebElement element = driver.findElement(locator);
        return element.findElement(locator1);
    }

    public static List<WebElement> getChildren(By locator, By locator1){
        WebElement element = driver.findElement(locator);
        return element.findElements(locator1);
    }

    public static List<WebElement> getChildren(By locator, By locator1, By locator2){
        WebElement element = driver.findElement(locator);
        WebElement element1 = element.findElement(locator1);
        return element1.findElements(locator2);
    }

    public static WebElement getChild(By locator, By locator1, By locator2){
        WebElement element, element1;
        try {
            element = driver.findElement(locator);
            element1 = element.findElement(locator1);
        } catch (NoSuchElementException exception){
            element = driver.findElement(locator);
            element1 = element.findElement(locator1);
        }
        return element1.findElement(locator2);
    }

    public static List<WebElement> getChildren(By locator, By locator1, By locator2, By locator3){
        WebElement element = driver.findElement(locator);
        WebElement element1 = element.findElement(locator1);
        WebElement element2 = element1.findElement(locator2);
        return element2.findElements(locator3);
    }

    public static List<WebElement> getChildren(By locator, By locator1, By locator2, By locator3, By locator4){
        WebElement element = driver.findElement(locator);
        WebElement element1 = element.findElement(locator1);
        WebElement element2 = element1.findElement(locator2);
        WebElement element3 = element2.findElement(locator3);
        return element3.findElements(locator4);
    }

    public static void saveToResults(String content){
        new MyFileWriter().writeToFile(content);
    }
}
