package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utilities.WebDriverUtils.*;

public class MainPage extends PageObject{

    @FindBy(id = "login")
    private WebElement login;

    @FindBy(id = "trigger")
    private WebElement trigger;

    @FindBy(css = ".menu-link")
    private List<WebElement> menuItems;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(xpath = "//*[text()='Moje dane']")
    private WebElement myData;

    @FindBy(css = "i[class*='bi-basket2']")
    private WebElement addToCart;

    @FindBy(id = "logout")
    private WebElement logout;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void login(){
        click(login);
        elementShouldBeVisible(username);
    }

    public void goToMyAccount(){
        click(trigger);
        click(menuItems.get(5));
        elementShouldBeVisible(myData);
    }

    public void logout(){
        click(logout);
        elementShouldBeVisible(trigger);
    }

    public void addItemToCart(String item){
        click(item);
        click(addToCart);
        elementShouldBeVisible(logout);
    }
}
