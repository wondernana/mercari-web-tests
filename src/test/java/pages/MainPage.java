package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
    @FindBy(xpath = "//header/descendant::input")
    private WebElement searchBar;
    @FindBy(xpath = "//header/descendant::a[contains(@href, 'login')]")
    private WebElement login;
    @FindBy(xpath = "//header/descendant::a[contains(@href, 'my page')]")
    private WebElement myPage;

    private WebDriver driver = null;

    public MainPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage goToLoginPage(){
        login.click();
        return new LoginPage(driver);
    }

    public SearchResultsPage submitSearchRequest (String text) {
        // clearing the search bar in case it has some predefined text
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(text, Keys.ENTER);
        return new SearchResultsPage(driver);
    }


    public MyPage goToMyPage() {
        myPage.click();
        return new MyPage(driver);
    }

}
