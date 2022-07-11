package pages.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

import static utilities.WebDriverUtils.click;
import static utilities.WebDriverUtils.elementShouldBeVisible;

public class DeleteUserPage extends PageObject {

    @FindBy(css = "i[class*='bi-check2-square']")
    private WebElement confirm;

    @FindBy(id = "trigger")
    private WebElement trigger;

    public DeleteUserPage(WebDriver driver) {
        super(driver);
    }

    public void submit(){
        click(confirm);
        elementShouldBeVisible(trigger);
    }
}
