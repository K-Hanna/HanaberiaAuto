package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;

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

    public static void click(By locator){
        WebElement element = driver.findElement(locator);
        elementShouldBeClickable(element);
        click(element);
    }

    public static String getAttribute(WebElement element, String attribute){
        return element.getAttribute(attribute);
    }

    public static String getTextFromElement(WebElement element){
        return element.getText();
    }

    public static List<String> getListOfTexts(List<WebElement> elements){
        List<String> textFromElements = new ArrayList<>();
        for(WebElement element : elements){
            textFromElements.add(getTextFromElement(element));
        }
        return textFromElements;
    }

    public static Set<String> getSetOfText(List<WebElement> elements){
        Set<String> textFromElements = new HashSet<>();
        for(WebElement element : elements){
            textFromElements.add(getTextFromElement(element));
        }
        return textFromElements;
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
