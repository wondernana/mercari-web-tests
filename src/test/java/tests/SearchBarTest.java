package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;


public class SearchBarTest extends TestBase {


    private WebDriver driver;


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = init(BrowserType.CHROME);

    }

    //defined in testng.xml
    @Parameters("request")
    @Test
    public void validateSearchResults(String request) throws Exception {

        SearchResultsPage searchResults =
                new MainPage(driver)
                .submitSearchRequest(request);

        searchResults.waitForResults(3);
        ItemDetailsPage itemDetails = searchResults.chooseResultByIndex(3);
        //getting item's title and making it lower case since user could've typed the word differently (e.g. MacBook|Macbook|macbook)
        String resultText = itemDetails.getItemTitle().toLowerCase();
        //comparing title to search request
        assertTrue(resultText.contains(request.toLowerCase()));

    }

    @AfterClass
    public void cleanUp() throws Exception {
        tearDown();
    }


}



