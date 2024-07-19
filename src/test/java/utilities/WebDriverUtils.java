package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
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

    public static void waitForElementToBeVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waiting(int milis){
        try{
            Thread.sleep(milis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

/*    public static boolean isParagraphVisible(){
        boolean isVisible = false;
        WebElement element = driver.findElement(By.cssSelector(".main-container"));
        WebElement element1 = element.findElement(By.cssSelector(".app-page-content.normal-scroll.not-ios-device"));
        try {
            WebElement paragraph = element1.findElement(By.cssSelector(".rendered-quill-content"));
            if(paragraph != null)
                isVisible = true;
        } catch (NoSuchElementException ignore){}

        return isVisible;
    }*/

    public static void elementShouldBeVisible(WebElement element){
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void elementShouldBeClickable(WebElement element){
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element){
        try {
            elementShouldBeVisible(element);
            elementShouldBeClickable(element);
            element.click();
        } catch (StaleElementReferenceException e){
            elementShouldBeVisible(element);
            elementShouldBeClickable(element);
            element.click();
        }
    }

    public static String getAttribute(WebElement element, String attribute){
        return element.getAttribute(attribute);
    }

    public static String getTextFromElement(WebElement element){
        return element.getText();
    }

    public static WebElement getSibling(WebElement element){
        return element.findElement(By.xpath("following-sibling::*"));
    }

    public static List<WebElement> getListOfElements(By locator){
        List<WebElement> elements;
        try{
            elements = driver.findElements(locator);
        } catch (StaleElementReferenceException e){
            driver.navigate().refresh();
            elements = driver.findElements(locator);
        }
        return elements;
    }

    public static List<WebElement> getChildren(By locator, By locator1, By locator2){
        waiting(500);
        
        WebElement element, element1;
        try {
            element = driver.findElement(locator);
            element1 = element.findElement(locator1);
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            driver.navigate().refresh();
            element = driver.findElement(locator);
            element1 = element.findElement(locator1);
        }
        return element1.findElements(locator2);
    }

    public static WebElement getChild(By locator, By locator1, By locator2){
        waiting(500);

        WebElement element, element1;
        try {
            element = driver.findElement(locator);
            element1 = element.findElement(locator1);
        } catch (StaleElementReferenceException e) {
            driver.navigate().refresh();
            element = driver.findElement(locator);
            element1 = element.findElement(locator1);
        }
        return element1.findElement(locator2);
    }

    public static List<WebElement> getChildren(By locator, By locator1, By locator2, By locator3){
        waiting(500);

        WebElement element, element1, element2;
        try {
            element = driver.findElement(locator);
            element1 = element.findElement(locator1);
            element2 = element1.findElement(locator2);
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            driver.navigate().refresh();
            element = driver.findElement(locator);
            element1 = element.findElement(locator1);
            element2 = element1.findElement(locator2);
        }
        return element2.findElements(locator3);
    }

    public static void saveToResults(String content){
        new MyFileWriter().writeToFile(content);
    }
}
