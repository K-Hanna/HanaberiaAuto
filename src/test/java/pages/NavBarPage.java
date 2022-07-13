package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.WebDriverUtils.*;

public class NavBarPage extends PageObject{

    @FindBy(css = "i[class*='bi-house']")
    private WebElement mainPage;

    @FindBy(xpath = "//*[text()='Moje dane']")
    private WebElement myAccount;

    @FindBy(xpath = "//*[text()='Rezerwacje']")
    private WebElement reservations;

    @FindBy(xpath = "//*[text()='Zamówienia']")
    private WebElement orders;

    @FindBy(xpath = "//*[text()='Produkty']")
    private WebElement products;

    @FindBy(id = "trigger")
    private WebElement trigger;

    @FindBy(xpath = "//*[text()='Login']")
    private WebElement login;

    @FindBy(xpath = "//*[text()='Mój koszyk']")
    private WebElement basket;

    @FindBy(xpath = "//*[text()='Moje zamówienia']")
    private WebElement myOrders;

    @FindBy(css = "i[class*='bi-plus-square']")
    private WebElement addProduct;

    @FindBy(id = "logout")
    private WebElement logout;

    public NavBarPage(WebDriver driver) {
        super(driver);
    }

    public void goToMainPage(){
        click(mainPage);
        elementShouldBeVisible(trigger);
    }

    public void goToMyAccount(){
        click(myAccount);
        elementShouldBeVisible(login);
    }

    public void goToReservations(){
        click(reservations);
        elementShouldBeVisible(basket);
    }

    public void goToUsersOrders(){
        click(orders);
        elementShouldBeVisible(myOrders);
    }

    public void goToProducts(){
        click(products);
        elementShouldBeVisible(addProduct);
    }

    public void goToAdminsOrders(){
        click(orders);
        elementShouldBeVisible(myOrders);
    }
}
