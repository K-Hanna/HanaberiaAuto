package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;
import pages.products.AddProductPage;
import pages.products.Products;
import pages.products.ProductsPage;
import utilities.BaseSteps;
import utilities.BaseTest;

import java.util.List;

public class CrudProductTest extends BaseTest {

    @BeforeMethod
    void goToProducts(){
        new MainPage(driver)
                .login();

        new BaseSteps()
                .logInAsAdmin(driver);

        new MainPage(driver)
                .goToMyAccount();

        new AccountPage(driver)
                .goToProducts();
    }

    @Test
    void createNewProduct(){

        List<Products> productsList = Products.generate();

        for(Products product : productsList){
            new ProductsPage(driver)
                    .addNewProduct();

            new AddProductPage(driver)
                    .fillImage(product.getImage())
                    .selectCategory(product.getCategory())
                    .fillName(product.getName())
                    .fillDescription(product.getDescription())
                    .fillPrice(product.getPrice())
                    .submit();
        }
    }
}
