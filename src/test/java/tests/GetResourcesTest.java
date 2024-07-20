package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.DetailsPage;
import pages.MainPage;
import pages.SecurityZone;
import utilities.BaseTest;

import java.util.List;

import static utilities.WebDriverUtils.*;

public class GetResourcesTest extends BaseTest {

    @Test
    public void getResources(){

        new SecurityZone(driver).passDanger();
        MainPage mainPage = new MainPage(driver);
        List<WebElement> tabs, cards;

        for(int i = 0; i < mainPage.getTabListSize(); i++){
            tabs = mainPage.getTabList();
            click(tabs.get(i));
            waitForPageToLoad();
            saveToResults("{\"" + getTextFromElement(tabs.get(i)) + "\" : [\n");

            int length = Math.min(mainPage.getCardsListSize(), 15);
            for(int j = 0; j < length; j ++){
                cards = mainPage.getCardsList();

                new DetailsPage(driver).getDetails(cards.get(j), i);
            }
        }
        saveToResults("]}]}");
    }
}
