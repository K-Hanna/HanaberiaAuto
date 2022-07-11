package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

import static utilities.WebDriverUtils.*;

public class AddProductPage extends PageObject {

    @FindBy(name = "imageName")
    private WebElement image;

    @FindBy(name = "category")
    private WebElement category;

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(name = "description")
    private WebElement description;

    @FindBy(name = "price")
    private WebElement price;

    @FindBy(css = "i[class*='bi-check2-square']")
    private WebElement confirm;

    @FindBy(css = "i[class*='bi-plus-square']")
    private WebElement addProduct;

    public AddProductPage(WebDriver driver) {
        super(driver);
    }

    public AddProductPage fillImage(String value){
        fill(image, value);
        return this;
    }

    public AddProductPage selectCategory(String value){
        select(category, value);
        return this;
    }

    public AddProductPage fillName(String value){
        fill(name, value);
        return this;
    }

    public AddProductPage fillDescription(String value){
        fill(description, value);
        return this;
    }

    public AddProductPage fillPrice(String value){
        fill(price, value);
        return this;
    }

    public void submit(){
        click(confirm);
        elementShouldBeVisible(addProduct);
    }
}
