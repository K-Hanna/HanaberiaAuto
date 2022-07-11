package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.users.AddUserPage;
import pages.users.DeleteUserPage;
import pages.users.EditUserPage;
import pages.users.UsersPage;
import utilities.BaseTest;

public class CrudUserTest extends BaseTest {

    @Test(priority = 1)
    void addUserTest(){

        MainPage mainPage = new MainPage(driver);

        mainPage.login();
        new LoginPage(driver).register();

        new AddUserPage(driver)
                .fillUserName("Ala")
                .fillContactForm("phone")
                .fillContact("987654321")
                .fillPasswords("12345")
                .submit();

        mainPage.login();
        new LoginPage(driver)
                .fillUserName("Ala")
                .fillPassword("12345")
                .submit();

        mainPage.goToMyAccount();
    }

    @Test(priority = 2)
    void editUserTest(){
        new UsersPage(driver).editUser();

        new EditUserPage(driver)
                .fillContactForm("email")
                .fillContact("ala@wp.pl")
                .fillPasswords("12345")
                .submit();
    }

    @Test(priority = 3)
    void deleteUserTest(){
        new UsersPage(driver).deleteUser();
        new DeleteUserPage(driver).submit();
    }
}
