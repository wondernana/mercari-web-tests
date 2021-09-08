package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInformation {
    @FindBy(xpath = "//a[contains(@href, 'shipping address')]")
    private WebElement shippingAddress;

    private WebDriver driver = null;

    public PersonalInformation (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ShippingAddress goToShippingAddress() {
        shippingAddress.click();
        return new ShippingAddress(driver);
    }

}
