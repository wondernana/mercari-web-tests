package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath="//input[@name='email' and not(@type='hidden')]")
    private WebElement email;
    @FindBy(xpath="//input[@name='password' and not(@type='hidden')]")
    private WebElement password;
    @FindBy(xpath="//button[@type='submit']")
    private WebElement button;

    private WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void submitValidLoginInfo(String userEmail, String userPassword) {
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        button.submit();
    }


}
