package tests.US_01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MustafaPgc;
import utilities.Driver;

import java.io.IOException;

public class US01_TC02 {
    @Test
    public void test02() throws IOException {
        MustafaPgc mustafaPgc = new MustafaPgc();
        //    1- Kullanici https://hubcomfy.com/ url adresine gider
        Driver.getDriver().get("https://hubcomfy.com/");
        //    2- Register yazisina tiklar
        mustafaPgc.register.click();
        //    3- Become a vendor yazisinin uzerine tiklar
        mustafaPgc.becomeAVendor.click();
        //    4- Acilan registration sayfasinda Email yazisinin oldugunu test eder
        Assert.assertTrue(mustafaPgc.emailYazisi.getText().contains("Email"));
        //    5- Email kutusunun gorunur oldugunu test eder
        Assert.assertTrue(mustafaPgc.emailKutusu.isDisplayed());
        //    6- Acilan registration sayfasinda Password  yazisinin oldugunu test eder
        Assert.assertTrue(mustafaPgc.passwordYazisi.getText().contains("Password"));
        //    7- Password kutusunun gorunur oldugunu test eder
        Assert.assertTrue(mustafaPgc.passwordKutusu.isDisplayed());
        //    8- Acilan registration sayfasinda Confirm Password yazisinin oldugunu test eder
        Assert.assertTrue(mustafaPgc.confirmPasswordYazisi.getText().contains("Confirm Password"));
        //    9- Comfirm password kutusunun gorunur oldugunu test eder
        Assert.assertTrue(mustafaPgc.confirmPasswordKutusu.isDisplayed());

        //ReusableMethods.getScreenshot("US01_TC02");

        Driver.closeDriver();
    }
}
