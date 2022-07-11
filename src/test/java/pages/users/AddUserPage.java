package pages.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

import static utilities.WebDriverUtils.*;

public class AddUserPage extends PageObject {

    @FindBy(id = "userName")
    private WebElement userNameInput;

    @FindBy(name = "contactForm")
    private WebElement contactFormInput;

    @FindBy(css = "i[class*='bi-envelope']")
    private WebElement eMail;

    @FindBy(css = "i[class*='bi-telephone']")
    private WebElement phone;

    @FindBy(id = "contact")
    private WebElement contactInput;

    @FindBy(id = "userPassword")
    private WebElement passwordInput;

    @FindBy(id = "confirmPassword")
    private WebElement confirmInput;

    @FindBy(css = ".btn-lg")
    private WebElement submitButton;

    @FindBy(id = "trigger")
    private WebElement trigger;

    public AddUserPage(WebDriver driver) {
        super(driver);
    }

    public AddUserPage fillUserName(String value){
        fill(userNameInput, value);
        return this;
    }

    public AddUserPage fillContactForm(String value){
        if(value.equals("email")){
            click(eMail);
        } else {
            click(phone);
        }

        return this;
    }

    public AddUserPage fillContact(String value){
        fill(contactInput, value);
        return this;
    }

    public AddUserPage fillPasswords(String value){
        fill(passwordInput, value);
        fill(confirmInput, value);
        return this;
    }

    public void submit(){
        click(submitButton);
        elementShouldBeVisible(trigger);
    }
}
