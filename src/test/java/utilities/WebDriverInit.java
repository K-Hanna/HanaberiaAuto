package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverInit {

    public static WebDriver setUpDriver(){
        WebDriver driver;

        switch (TestData.getBrowser()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/binaries/chromedriver.exe");
                driver = new ChromeDriver(setChromeOptions());
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "src/test/resources/binaries/geckodriver.exe");
                driver = new FirefoxDriver(setFirefoxOptions());
            }
            case "edge" -> {
                System.setProperty("webdriver.edge.driver", "src/test/resources/binaries/msedgedriver.exe");
                driver = new EdgeDriver();
            }
            default -> throw new IllegalArgumentException("Wrong browser provided");
        }

        driver.manage().window().maximize();
        return driver;
    }

    private static ChromeOptions setChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return options;
    }

    private static FirefoxOptions setFirefoxOptions(){
        return new FirefoxOptions();
    }
}
