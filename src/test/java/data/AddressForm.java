package data;

import org.testng.annotations.DataProvider;

public class AddressForm {
    @DataProvider(name = "validAddress")
    public static Object[][] validAddressData(){
        return new Object[][] {
            {"古室", "哲也", "こむろ", "てつや", "111-0021", "大阪府", "大阪府"}
        };
    }
}