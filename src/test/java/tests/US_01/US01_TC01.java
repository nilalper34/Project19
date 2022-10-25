package tests.US_01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MustafaPgc;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US01_TC01 {

    MustafaPgc mustafaPgc = new MustafaPgc();

    @Test
    public void test01() throws InterruptedException, IOException {

        //  1- Kullanici https://hubcomfy.com/ url adresine gider
        Driver.getDriver().get("https://hubcomfy.com/");
        //  2- Register yazisina tiklar
        mustafaPgc.register.click();
        //  3- Acilan pencerede Become a Vendor yazisinin gorundugunu test eder
        ReusableMethods.waitFor(2);
        Assert.assertTrue(mustafaPgc.becomeAVendor.isDisplayed());

        //  4- Become a vendor yazisinin uzerine tiklar
        mustafaPgc.becomeAVendor.click();
        //  5- Vendor Registration yazisinin gorunurlugunu test eder
        Assert.assertTrue(mustafaPgc.vendorRegistrationYazisi.isDisplayed());

        //ReusableMethods.getScreenshot("US01_TC01");
        Driver.closeDriver();

    }
}
