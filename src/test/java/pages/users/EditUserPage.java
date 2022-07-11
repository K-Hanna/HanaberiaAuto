package pages.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

import static utilities.WebDriverUtils.*;

public class EditUserPage extends PageObject {

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

    @FindBy(css = "i[class*='bi-check2-square']")
    private WebElement submitButton;

    @FindBy(css = "i[class*='bi-pencil-square']")
    private WebElement editButton;

    public EditUserPage(WebDriver driver) {
        super(driver);
    }

    public EditUserPage fillUserName(String value){
        fill(userNameInput, value);
        return this;
    }

    public EditUserPage fillContactForm(String value){
        if(value.equals("email")){
            click(eMail);
        } else {
            click(phone);
        }

        return this;
    }

    public EditUserPage fillContact(String value){
        fill(contactInput, value);
        return this;
    }

    public EditUserPage fillPasswords(String value){
        fill(passwordInput, value);
        fill(confirmInput, value);
        return this;
    }

    public void submit(){
        click(submitButton);
        elementShouldBeVisible(editButton);
    }
}
