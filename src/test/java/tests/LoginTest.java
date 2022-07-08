package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.products.Products;
import utilities.BaseTest;

import java.util.List;

import static utilities.GetData.*;

public class LoginTest extends BaseTest {

    @Test
    public void login(){

        new MainPage(driver).login();

        String login = "";
        String password = "";

        switch (loginAs()) {
            case "user" -> {
                login = userLogin();
                password = userPassword();
            }
            case "admin" -> {
                login = adminLogin();
                password = adminPassword();
            }
            default -> System.out.println("Wrong login");
        }

        new LoginPage(driver)
                .fillUserName(login)
                .fillPassword(password)
                .submit();

        List<Products> productsList = Products.generate();

        for(Products products : productsList){
            System.out.println(products);
        }
    }
}
