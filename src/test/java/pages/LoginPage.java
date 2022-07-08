package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.WebDriverUtils.*;

public class LoginPage extends PageObject {

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = ".btn")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillUserName(String username){
        fill(userNameInput, username);
        return this;
    }

    public LoginPage fillPassword(String password){
        fill(passwordInput, password);
        return this;
    }

    public void submit(){
        click(submitButton);
    }
}
