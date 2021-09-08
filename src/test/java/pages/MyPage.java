package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyPage {
    @FindBy(xpath = "//a[contains(@href, 'personal info')]")
    private WebElement personalInfo;

    private WebDriver driver = null;

    public MyPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PersonalInformation goToPersonalInfo() {
        personalInfo.click();
        return new PersonalInformation(driver);
    }
}
