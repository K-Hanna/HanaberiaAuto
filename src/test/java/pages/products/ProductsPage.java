package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

import java.util.ArrayList;
import java.util.List;

import static utilities.WebDriverUtils.*;

public class ProductsPage extends PageObject {

    @FindBy(css = "i[class*='bi-plus-square']")
    private WebElement addProduct;

    @FindBy(css = "i[class*='bi-check2-square']")
    private WebElement confirm;

    @FindBy(css = "i[class*='bi-pencil-square']")
    private List<WebElement> editProductIcons;

    @FindBy(css = "i[class*='bi-x-square']")
    private List<WebElement> deleteProductIcons;

    @FindBy(css = ".nav-item")
    private List<WebElement> navItems;

    @FindBy(name = "name")
    private List<WebElement> productNames;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addProduct(){
        click(addProduct);
        elementShouldBeVisible(confirm);
    }

    public void editProduct(int position){
        click(editProductIcons.get(position));
        elementShouldBeVisible(confirm);
    }

    public void deleteProduct(int position){
        click(deleteProductIcons.get(position));
        elementShouldBeVisible(confirm);
    }

    public void goToTab(int tabNumber){
        click(navItems.get(tabNumber));
    }

    public List<String> getProductsNames(){
        List<String> names = new ArrayList<>();
        for(WebElement element : productNames){
            names.add(element.getText());
        }

        return names;
    }
}
