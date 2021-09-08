package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;
import pages.MainPage;

import java.time.Duration;

import static org.testng.Assert.fail;

public class TestBase {

    private WebDriver driver;
    private String baseUrl = "https://www.google.com/";
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    // this could be used to run tests in different browsers
    public WebDriver init(String browser) {
        switch (browser){
            case(BrowserType.FIREFOX):
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case(BrowserType.CHROME):
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case(BrowserType.OPERA):
                System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
                driver = new OperaDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       goToMainPage();
       return driver;
    }

    public void goToMainPage() {
        driver.get("https://www.mercari.com/jp/");
    }

    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
