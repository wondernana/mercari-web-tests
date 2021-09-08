package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class SearchResultsPage {

    @FindAll({
            @FindBy(xpath = "//section[@class='items-box']/following::div")
    })
        private List<WebElement> searchResults;

        private WebDriver driver = null;

        public SearchResultsPage (WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public ItemDetailsPage chooseResultByIndex(int index) {
            searchResults.get(index).click();
            return new ItemDetailsPage(driver);
        }

        public void waitForResults(int seconds) {
            new WebDriverWait(driver, Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".items-box-body")));
        }

    }

