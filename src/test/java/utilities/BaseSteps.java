package utilities;

import org.openqa.selenium.WebDriver;
import static utilities.TestData.getBaseUrl;

public class BaseSteps extends BaseTest {

    protected static WebDriver driver;

    public static String baseUrl(){
        return getBaseUrl();
    }

}
