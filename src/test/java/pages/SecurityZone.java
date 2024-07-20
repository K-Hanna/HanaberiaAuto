package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.WebDriverUtils.click;
import static utilities.WebDriverUtils.waitForPageToLoad;

public class SecurityZone extends PageObject{

    @FindBy(id = "details-button")
    private WebElement detailsButton;

    @FindBy(id = "proceed-link")
    private WebElement proceedLink;

    public SecurityZone(WebDriver driver){
        super(driver);
        waitForPageToLoad();
    }

    public void passDanger(){
        click(detailsButton);
        click(proceedLink);
    }
}
