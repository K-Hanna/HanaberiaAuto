package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

import static utilities.WebDriverUtils.*;

public class AddProductPage extends PageObject {

    @FindBy(name = "imageName")
    WebElement image;

    @FindBy(name = "category")
    WebElement category;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "description")
    WebElement description;

    @FindBy(name = "price")
    WebElement price;

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
