package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.WebDriverUtils.*;

import java.util.*;

public class MainPage extends PageObject{

    @FindBy(id = "details-button")
    private WebElement detailsButton;

    @FindBy(id = "proceed-link")
    private WebElement proceedLink;

    @FindBy(css = "[aria-label='Navigate Back']")
    private WebElement backButton;

    private final By logo = By.cssSelector(".sidenav__logo");
    private final By tabsLabels = By.cssSelector("[id^=mat-tab-label]");

    public MainPage(WebDriver driver) {
        super(driver);
        waitForPageToLoad();
        passDanger();
        waitForPageToLoad();
        waitForElementToBeVisible(logo);
    }

    public void navigate(){

        List<WebElement> tabs = driver.findElements(tabsLabels);

        for(WebElement tab : tabs){
            click(tab);
            waitForPageToLoad();
            saveToResults(getTextFromElement(tab) + "\n");
            List<WebElement> cards = getChildren(By.cssSelector(".main-container"),
                    By.cssSelector(".resources-list.resources-list__scroll.with-navigator"),
                    By.cssSelector(".resources-card-beta.with-navigator.ng-star-inserted"));

            int length = Math.min(cards.size() - 1, 15);
            for(int i = 0; i < length; i ++){
                saveToResults(getAttribute(cards.get(i), By.tagName("a"),"aria-label") + "\n");
                getDetails(cards.get(i));
            }
        }
    }

    private void passDanger(){
        click(detailsButton);
        click(proceedLink);
    }

    private void getDetails(WebElement element){
        click(element);
        waiting(1000);

        WebElement image = getChild(By.cssSelector(".main-container"),
                By.cssSelector(".app-page-content.normal-scroll.not-ios-device"),By.tagName("img"));
        String source = getScr(image);
        saveToResults("Image: " + source + "\n");

        WebElement paragraph = getChild(By.cssSelector(".main-container"),
                By.cssSelector(".app-page-content.normal-scroll.not-ios-device"),
                By.cssSelector(".rendered-quill-content"));
        String description = getTextFromElement(paragraph);
        saveToResults("Description: " + description + "\n");

        getMatTabLabelContent();
        click(backButton);
    }

    private void getMatTabLabelContent(){
        List<WebElement> matTabLabelContent = getChildren(By.cssSelector(".main-container"),
                By.cssSelector(".app-page-content.normal-scroll.not-ios-device"),
                By.cssSelector(".mat-tab-label-content"));

        for(WebElement element : matTabLabelContent){
            if(!getTextFromElement(element).equals("AVAILABILITY")) {
                click(element);
                saveToResults(getTextFromElement(element));
                List<WebElement> spans = getChildren(By.cssSelector(".main-container"),
                        By.cssSelector(".mat-tab-group.resource-details__data.mat-primary"),
                        By.cssSelector(".mat-tab-body-wrapper"),
                        By.tagName("span"));
                spans.removeIf(sth -> sth.getText().isEmpty());
                spans.removeIf(sth -> sth.getText().contains("_"));
                spans.removeIf(sth -> sth.getText().equals(" "));

                List<WebElement> parahraphs = getChildren(By.cssSelector(".main-container"),
                        By.cssSelector(".mat-tab-group.resource-details__data.mat-primary"),
                        By.cssSelector(".mat-tab-body-wrapper"),
                        By.tagName("p"));

                if(parahraphs.size() != 0) {
                    for (int i = 0; i < spans.size() - 1; i++) {
                        saveToResults(spans.get(i).getText() + ": " + parahraphs.get(i).getText() + "\n");
                    }
                } else {
                    Set<String> spanSet = new HashSet<>();
                    for (WebElement span : spans) {
                        spanSet.add(span.getText());
                    }
                    saveToResults(Arrays.toString(spanSet.toArray()) + "\n");
                }
            }
        }
    }
}
