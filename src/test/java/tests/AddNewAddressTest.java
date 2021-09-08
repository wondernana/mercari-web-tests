/* This test includes a lot of assumptions since I can't register an account. These assumptions are based on:
- style (names of attributes etc.) of pages I have access to (like main page, login or registration page)
- my personal experience with similar apps
 */
package tests;

import data.AddressForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddNewAddressTest extends TestBase {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = init(BrowserType.CHROME);
    }

    //parameters defined in testng.xml
    @Parameters({"email", "password"})
    @BeforeMethod
    //user should be logged in to access MyPage
    public void login(String email, String password) {
        new MainPage(driver)
                .goToLoginPage()
                .submitValidLoginInfo(email, password);
    }


    @Test(dataProvider = "validAddress", dataProviderClass = AddressForm.class)
    public void testNewAddressAddition(String firstNameKanji, String familyNameKanji, String firstNameKana,
                                       String familyNameKana, String postalCode, String prefectures, String municipalities) {

        ShippingAddress shipAddress = new MainPage(driver)
                .goToMyPage()
                .goToPersonalInfo()
                .goToShippingAddress();

        //saving the number of addresses user had before
        int addressCountBefore = shipAddress.getAddressList().size();
        shipAddress.addShippingAddress();

        AddressRegistration registration = new AddressRegistration(driver);
        registration.fillInAddressForm(firstNameKanji, familyNameKanji, firstNameKana,
                familyNameKana, postalCode, prefectures, municipalities);

        registration.waitForMessage(3);

        ShippingAddress shippingAddressNew = new ShippingAddress(driver);
        shippingAddressNew.waitForNewAddress(3);

        //checking if number of addresses increased by 1
        assertEquals(shippingAddressNew.getAddressList().size(), addressCountBefore + 1);

        //checking if the last address of the list contains the information that we've just added
        String expectedText = firstNameKanji + familyNameKanji + firstNameKana + familyNameKana +
                postalCode + prefectures + municipalities;
        assertTrue(shippingAddressNew.getLastAddressText().contains(expectedText));

    }
    @AfterClass
    public void cleanUp() throws Exception {
        tearDown();
    }

}
