package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.products.ProductsPage;

import static utilities.WebDriverUtils.*;

public class AccountPage extends PageObject{

    @FindBy(xpath = "//*[text()='Produkty']")
    private WebElement products;

    @FindBy(css = "i[class*='bi-plus-square']")
    private WebElement addProduct;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void goToProducts(){
        click(products);
        elementShouldBeVisible(addProduct);
    }
}
