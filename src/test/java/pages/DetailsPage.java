package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

import static utilities.WebDriverUtils.*;
import static utilities.WebDriverUtils.saveToResults;

public class DetailsPage extends PageObject {

    private final By mainContainer = By.cssSelector(".main-container");
    private final By pageContent = By.cssSelector(".app-page-content.normal-scroll.not-ios-device");
    private final By resource = By.cssSelector(".resource-summary__title");
    private final By imageTag = By.tagName("img");
    private final By renderedContent = By.cssSelector(".rendered-quill-content");
    private final By matTabContent = By.cssSelector(".mat-tab-label-content");
    private final By groupResource = By.cssSelector(".mat-tab-group.resource-details__data.mat-primary");
    private final By bodyWrapper = By.cssSelector(".mat-tab-body-wrapper");
    private final By spanTag = By.tagName("span");
    private final By pTag = By.tagName("p");
    private final By backButton = By.cssSelector("[aria-label='Navigate Back']");
    private final By logoIcon = By.cssSelector(".sidenav__logo");

    public DetailsPage(WebDriver driver){
        super(driver);
        waitForPageToLoad();
    }

    public void getDetails(WebElement element, int i){
        click(element);
        waiting(1000);

        WebElement titleLabel = getChild(mainContainer, pageContent, resource);
        String title = getTextFromElement(titleLabel);
        saveToResults("{\"Title\" : \"" + title + "\",\n");

        WebElement image = getChild(mainContainer, pageContent, imageTag);
        String source = getAttribute(image, "src");
        saveToResults("\"Image\" : \"" + source + "\",\n");

        if(i == 0){
            WebElement paragraph = getChild(mainContainer, pageContent, renderedContent);
            String description = getTextFromElement(paragraph);
            saveToResults("\"Description\" : \"" + description + "\",\n");
        }

        getMatTabLabelContent();
        click(backButton);
        waitForElementToBeVisible(logoIcon);
        waiting(1000);
    }

    private void getMatTabLabelContent(){
        List<WebElement> matTabLabelContent = getChildren(mainContainer, pageContent, matTabContent);

        for(WebElement element : matTabLabelContent){
            if(!getTextFromElement(element).contains("AVAILABILITY")) {
                click(element);
                saveToResults("\"" + getTextFromElement(element) + "\": ");

                List<WebElement> spans = getChildren(mainContainer, groupResource, bodyWrapper, spanTag);
                spans.removeIf(sth -> sth.getText().isEmpty());
                spans.removeIf(sth -> sth.getText().contains("_"));
                spans.removeIf(sth -> sth.getText().equals(" "));

                List<WebElement> paragraph = getChildren(mainContainer, groupResource, bodyWrapper, pTag);

                if(paragraph.size() != 0) {
                    saveToResults("\n[{\n");
                    List<String> spanList = getListOfTexts(spans);
                    List<String> paragraphList = getListOfTexts(paragraph);
                    for (int i = 0; i < spans.size(); i++) {
                        saveToResults("\"" + spanList.get(i) + "\" : \""
                                + paragraphList.get(i) + "\"");
                        if(i == spans.size() - 1)
                            saveToResults("\n");
                        else
                            saveToResults(",\n");
                    }
                    saveToResults("}],\n");
                } else {
                    Set<String> spanSet = getSetOfText(spans);
                    String spanSetToString = Arrays.toString(spanSet.toArray());
                    saveToResults("\"" + spanSetToString.substring(1, spanSetToString.length() - 1) + "\"");
                    if(getTextFromElement(element).contains("PATH"))
                        saveToResults(",\n");
                    else
                        saveToResults("\n},\n");
                }
            }
        }
    }
}
