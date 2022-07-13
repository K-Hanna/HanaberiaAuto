package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.NavBarPage;
import utilities.BaseSteps;
import utilities.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){

        MainPage mainPage = new MainPage(driver);

        mainPage.login();
        new BaseSteps().logInAs(driver);
        mainPage.goToMyAccount();

        NavBarPage navBarPage = new NavBarPage(driver);

        navBarPage.goToReservations();
        navBarPage.goToUsersOrders();
        navBarPage.goToMyAccount();
        navBarPage.goToMainPage();

        mainPage.logout();
    }
}
