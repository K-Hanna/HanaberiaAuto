package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

import static utilities.WebDriverUtils.click;
import static utilities.WebDriverUtils.elementShouldBeVisible;

public class DeleteProductPage extends PageObject {

    @FindBy(css = "i[class*='bi-check2-square']")
    private WebElement confirm;

    @FindBy(css = "i[class*='bi-plus-square']")
    private WebElement addProduct;

    public DeleteProductPage(WebDriver driver) {
        super(driver);
    }

    public void submit(){
        click(confirm);
        elementShouldBeVisible(addProduct);
    }
}
