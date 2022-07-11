package pages.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

import static utilities.WebDriverUtils.*;

public class UsersPage extends PageObject {

    @FindBy(css = "i[class*='bi-pencil-square']")
    private WebElement editUser;

    @FindBy(css = "i[class*='bi-x-square']")
    private WebElement deleteUser;

    @FindBy(css = "i[class*='bi-check2-square']")
    private WebElement confirm;

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    public void editUser(){
        click(editUser);
        elementShouldBeVisible(confirm);
    }

    public void deleteUser(){
        click(deleteUser);
        elementShouldBeVisible(confirm);
    }
}
