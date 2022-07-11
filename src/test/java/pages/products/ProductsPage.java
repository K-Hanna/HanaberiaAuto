package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

import static utilities.WebDriverUtils.*;

public class ProductsPage extends PageObject {

    @FindBy(css = "i[class*='bi-plus-square']")
    private WebElement addProduct;

    @FindBy(css = "i[class*='bi-check2-square']")
    private WebElement confirm;

    @FindBy(css = "i[class*='bi-pencil-square']")
    private WebElement editProduct;

    @FindBy(css = "i[class*='bi-x-square']")
    private WebElement deleteProduct;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addNewProduct(){
        click(addProduct);
        elementShouldBeVisible(confirm);
    }
}
