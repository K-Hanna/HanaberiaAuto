package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.WebDriverUtils.*;

public class NavBarPage extends PageObject{

    @FindBy(xpath = "//*[text()='Produkty']")
    private WebElement products;

    @FindBy(css = "i[class*='bi-plus-square']")
    private WebElement addProduct;

    public NavBarPage(WebDriver driver) {
        super(driver);
    }

    public void goToProducts(){
        click(products);
        elementShouldBeVisible(addProduct);
    }
}
