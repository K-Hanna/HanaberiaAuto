package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtils extends BaseTest{

    public static WebElement elementShouldBeVisible(WebElement element){
        return explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement elementShouldBeClickable(WebElement element){
        return explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element){
        elementShouldBeVisible(element);
        elementShouldBeClickable(element);
        element.click();
    }

    public static void fill(WebElement element, String value){
        elementShouldBeVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    public static void select(WebElement element, String value){
        Select dropDown = new Select(element);
        dropDown.selectByValue(value);
    }
}