package tests.US_04;

//1. Vendor url'ye adresine gider
//        2. Vendor signin butonuna tıklar
//        3. Vendor gecerli bir username girer
//        4. Vendor gecerli bir password girer
//        5. Vendor sign in butonuna basar
//        6. Vendor cart'a tıklar
//        7. Vendor view Cart'a tıklar
//        8. Vendor Shipping bilgilerini ve toplam tutarı gorebilmeli

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Erhanpgc;
import utilities.Driver;


public class US04_TC07ShippingInfo  {

    public static Erhanpgc erhanpgc = new Erhanpgc();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    public static SoftAssert softAssert = new SoftAssert();
    public static Actions actions = new Actions(Driver.getDriver());

    @Test(priority = 7)
    public void tc07_ShippingInfo() throws InterruptedException {
        US04_TC01AddFiveItems.tc01AddFiveItems();

        //8. Vendor Shipping bilgilerini ve toplam tutarı gorebilmeli
        softAssert.assertTrue(erhanpgc.cartShippingDestination.isDisplayed(),"Check Shipping destination");

        softAssert.assertAll("Check Assertions");

        Driver.getDriver().quit();

    }
}
