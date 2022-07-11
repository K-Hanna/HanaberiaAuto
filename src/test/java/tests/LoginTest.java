package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import utilities.BaseSteps;
import utilities.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){

        new MainPage(driver).login();
        new BaseSteps().logInAs(driver);
    }
}
