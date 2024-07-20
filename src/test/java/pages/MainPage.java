package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utilities.WebDriverUtils.*;

import java.util.*;

public class MainPage extends PageObject{

    private final By logoIcon = By.cssSelector(".sidenav__logo");
    private final By tabsLabels = By.cssSelector("[id^=mat-tab-label]");
    private final By mainContainer = By.cssSelector(".main-container");
    private final By resourceList = By.cssSelector(".resources-list.resources-list__scroll.with-navigator");
    private final By resourceCard = By.cssSelector(".resources-card-beta.with-navigator.ng-star-inserted");

    public MainPage(WebDriver driver) {
        super(driver);
        waitForPageToLoad();
        waitForElementToBeVisible(logoIcon);
    }

    public int getTabListSize(){
        List<WebElement> list = getTabList();
        return list.size();
    }

    public int getCardsListSize(){
        List<WebElement> list = getCardsList();
        return list.size();
    }
    public List<WebElement> getTabList(){
        return getListOfElements(tabsLabels);
    }

    public List<WebElement> getCardsList(){
        return getChildren(mainContainer, resourceList, resourceCard);
    }
}
