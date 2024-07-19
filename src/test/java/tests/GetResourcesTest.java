package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import utilities.BaseTest;

public class GetResourcesTest extends BaseTest {

    @Test
    public void getResources(){

        new MainPage(driver).navigate();

    }
}
