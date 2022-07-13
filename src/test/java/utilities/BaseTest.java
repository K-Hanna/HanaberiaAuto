package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import static utilities.BaseSteps.baseUrl;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait explicitWait;

    @BeforeClass
    public void setUpClass(){

        setUpDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl());
        driver.manage().window().maximize();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.pollingEvery(Duration.ofSeconds(2));
    }

    private void setUpDriver(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterClass
    public void tearDownClass() {
        driver.quit();
    }
}
