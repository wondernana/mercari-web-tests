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

public class ShippingAddress {

    @FindAll({
            @FindBy(xpath = "//div[@class='address-list-item']")
    })
    private List<WebElement> addressList;

    @FindBy(xpath = "(//div[@class='address-list-item'])[last()]")
    private WebElement lastAddress;

    @FindBy(xpath = "//a[contains(@href, 'add')]")
    private WebElement add;

    private WebDriver driver = null;

    public ShippingAddress (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addShippingAddress() {
        add.click();
    }

    public List<WebElement> getAddressList() {
        return addressList;
    }

    public void waitForNewAddress(int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='address-list-item'])[last()]")));
    }

    public String getLastAddressText() {
        return lastAddress.getText();
    }
}
