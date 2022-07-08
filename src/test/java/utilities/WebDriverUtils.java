package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebDriverUtils extends BaseTest{

    public static void click(WebElement element){
        elementShouldBeVisible(element);
        elementShouldBeClickable(element);
        element.click();
    }

    public static WebElement elementShouldBeVisible(WebElement element){
        return explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement elementShouldBeClickable(WebElement element){
        return explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void fill(WebElement element, String value){
        elementShouldBeVisible(element);
        element.clear();
        element.sendKeys(value);
    }
}
