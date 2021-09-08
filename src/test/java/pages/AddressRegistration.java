package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class AddressRegistration {
    @FindBy(xpath = "//input[@name='family_name_kanji']")
    private WebElement familyNameKanjiField;
    @FindBy(xpath = "//input[@name='first_name_kanji']")
    private WebElement firstNameKanjiField;
    @FindBy(xpath = "//input[@name='family_name_kana']")
    private WebElement familyNameKanaField;
    @FindBy(xpath = "//input[@name='first_name_kana']")
    private WebElement firstNameKanaField;
    @FindBy(xpath = "//input[@name='postal_code']")
    private WebElement postalCodeField;
    @FindBy(xpath = "//select[@name='prefectures']")
    private Select prefecturesField;
    @FindBy(xpath = "//input[@name='municipalities']")
    private WebElement municipalitiesField;
    @FindBy(xpath = "//button[@type='submit']")

    private WebElement button;

    private WebDriver driver = null;

    private WebDriverWait wait;



    public AddressRegistration (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInAddressForm(String firstNameKanji, String familyNameKanji, String firstNameKana,
                                  String familyNameKana, String postalCode, String prefectures, String municipalities) {

        familyNameKanjiField.sendKeys(familyNameKanji);
        firstNameKanjiField.sendKeys(firstNameKanji);
        familyNameKanaField.sendKeys(familyNameKana);
        firstNameKanaField.sendKeys(firstNameKana);
        postalCodeField.sendKeys(postalCode);
        prefecturesField.selectByVisibleText(prefectures);
        municipalitiesField.sendKeys(municipalities);
        button.click();

    }

    public void waitForMessage(int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            Alert alert = wait.until(alertIsPresent());
            alert.accept();
        } catch (NoAlertPresentException e) {
            return;
        }
    }


}
