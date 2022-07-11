package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.users.AddUserPage;
import pages.users.DeleteUserPage;
import pages.users.EditUserPage;
import pages.users.UsersPage;
import utilities.BaseTest;

import static utilities.BaseSteps.*;

public class CrudUserTest extends BaseTest {

    @Test(priority = 1)
    void addUserTest(){

        MainPage mainPage = new MainPage(driver);

        mainPage.login();
        new LoginPage(driver).register();

        new AddUserPage(driver)
                .fillUserName(newLogin())
                .fillContactForm(newContactForm1())
                .fillContact(newContact1())
                .fillPasswords(newPassword())
                .submit();

        mainPage.login();
        new LoginPage(driver)
                .fillUserName(newLogin())
                .fillPassword(newPassword())
                .submit();

        mainPage.goToMyAccount();
    }

    @Test(priority = 2)
    void editUserTest(){
        new UsersPage(driver).editUser();

        new EditUserPage(driver)
                .fillContactForm(newContactForm2())
                .fillContact(newContact2())
                .fillPasswords(newPassword())
                .submit();
    }

    @Test(priority = 3)
    void deleteUserTest(){
        new UsersPage(driver).deleteUser();
        new DeleteUserPage(driver).submit();
    }
}
