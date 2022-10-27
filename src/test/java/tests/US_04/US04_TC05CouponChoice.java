package tests.US_04;

//1. Vendor url'ye adresine gider
//        2. Vendor signin butonuna tıklar
//        3. Vendor gecerli bir username girer
//        4. Vendor gecerli bir password girer
//        5. Vendor sign in butonuna basar
//        6. Vendor cart'a tıklar
//        7. Vendor view Cart'a tıklar
//        8. Vendor Coupon secenegini gorebilmeli


import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Erhanpgc;

import utilities.Driver;

public class US04_TC05CouponChoice  {

    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    public static Erhanpgc erhanpgc = new Erhanpgc();

    @Test(priority = 5)
    public void tc05_CouponChoice() throws InterruptedException {
        US04_TC01AddFiveItems.tc01AddFiveItems();

        //8. Vendor Coupon secenegini gorebilmeli
        Assert.assertTrue(erhanpgc.applyCouponButton.isDisplayed(),"Check apply coupon button");

        Driver.getDriver().quit();
    }
}
