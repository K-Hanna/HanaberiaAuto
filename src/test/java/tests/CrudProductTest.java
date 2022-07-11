package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.NavBarPage;
import pages.MainPage;
import pages.products.*;
import utilities.BaseSteps;
import utilities.BaseTest;

import java.util.List;

public class CrudProductTest extends BaseTest {

    private List<Products> products;

    @BeforeClass
    void goToProducts(){
        new MainPage(driver)
                .login();

        new BaseSteps()
                .logInAsAdmin(driver);

        new MainPage(driver)
                .goToMyAccount();

        new NavBarPage(driver)
                .goToProducts();

        products = Products.generate();
    }

    @Test(priority = 1)
    void createProductTest(){

        for(Products product : products){
            new ProductsPage(driver)
                    .addProduct();

            new AddProductPage(driver)
                    .fillImage(product.getImage())
                    .selectCategory(product.getCategory())
                    .fillName(product.getName())
                    .fillDescription(product.getDescription())
                    .fillPrice(product.getPrice())
                    .submit();
        }
    }

    @Test(priority = 2)
    void editProductTest(){

        ProductsPage productsPage = new ProductsPage(driver);

        for(Products product : products){
            goToCategory(product.getCategory());
            List<String> names = productsPage.getProductsNames();

            for (int i = 0; i < names.size(); i++) {
                if(names.get(i).equals(product.getName())){
                    productsPage.editProduct(i);

                    new EditProductPage(driver)
                            .fillDescription("bbb")
                            .submit();
                }
            }
        }
    }

    @Test(priority = 3)
    void deleteProductTest(){

        ProductsPage productsPage = new ProductsPage(driver);

        for(Products product : products){
            goToCategory(product.getCategory());
            List<String> names = productsPage.getProductsNames();

            for (int i = 0; i < names.size(); i++) {
                if(names.get(i).equals(product.getName())){
                    productsPage.deleteProduct(i);

                    new DeleteProductPage(driver)
                            .submit();
                }
            }
        }
    }

    @AfterClass
    void logOut(){
        new MainPage(driver).logout();
    }

    private void goToCategory(String category){
        switch (category) {
            case "BRACELET" -> new ProductsPage(driver).goToTab(4);
            case "EARRINGS" -> new ProductsPage(driver).goToTab(5);
            case "NECKLACE" -> new ProductsPage(driver).goToTab(6);
            case "RING" -> new ProductsPage(driver).goToTab(7);
            default -> System.out.println("Wrong category given.");
        }
    }
}
