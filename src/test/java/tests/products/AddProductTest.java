package tests.products;

import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.MainPage;
import pages.products.AddProductPage;
import pages.products.Products;
import pages.products.ProductsPage;
import utilities.BaseTest;

import java.util.List;

import static pages.products.Products.generate;
import static utilities.GetData.*;

public class AddProductTest extends BaseTest {

    @Test
    void addNewProduct(){

        new MainPage(driver)
                .login();

        new LoginPage(driver)
                .fillUserName(adminLogin())
                .fillPassword(adminPassword())
                .submit();

        new MainPage(driver)
                .goToMyAccount();

        new AccountPage(driver)
                .goToProducts();

        List<Products> products = generate();

        for(Products product : products) {

            new ProductsPage(driver)
                    .addNewProduct();

            new AddProductPage(driver)
                    .fillImage(product.getImage())
                    .fillName(product.getName())
                    .fillDescription(product.getDescription())
                    .fillPrice(product.getPrice())
                    .submit();
        }
    }
}
