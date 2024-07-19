package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import static utilities.BaseSteps.baseUrl;
import static utilities.PreconditionSetter.setProperties;
import static utilities.WebDriverInit.setUpDriver;
import static utilities.WebDriverUtils.waiting;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait explicitWait;

    @BeforeClass
    public void setUpClass(){

        MyFileWriter.clearContent();

        setProperties();
        driver = setUpDriver();
        driver.get(baseUrl());

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.pollingEvery(Duration.ofSeconds(2));
    }

    @AfterClass
    public void tearDownClass() {
        driver.quit();
    }
}
