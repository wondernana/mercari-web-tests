package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDetailsPage {
    @FindBy(xpath = "//h1")
    private WebElement itemTitle;

    private WebDriver driver;

    public ItemDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getItemTitle() {
        return itemTitle.getText();
    }
}
