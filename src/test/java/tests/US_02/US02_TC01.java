package tests.US_02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MustafaPgc;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US02_TC01 {

    @Test
    public void test01() throws IOException {
        MustafaPgc mustafaPgc = new MustafaPgc();
        Actions actions = new Actions(Driver.getDriver());

        //  1- Kullanici https://hubcomfy.com/ url adresine gider
        Driver.getDriver().get("https://hubcomfy.com/");
        //  2- Signin yazisinin uzerine tiklar
        mustafaPgc.signIn.click();
        //  3- Email adresini girer
        mustafaPgc.signInUsername.sendKeys("tewas48407@dicopto.com");
        //  4- Passwordunu girer
        mustafaPgc.signInPassword.sendKeys("tewas48407.");
        //  5- Signin butonuna tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        mustafaPgc.signIn2butonu.click();
        //  6- Signout butonunun solundaki simgeyi veya sayfanin sonundaki My Accountu tiklar
        ReusableMethods.waitFor(2);
        mustafaPgc.myAccountSimge.click();
        //  7- Sisteme basarili bir giris yapidigini gosteren My Account yazisinin gorundugunu test eder
        Assert.assertTrue(mustafaPgc.myAccountYazisi.isDisplayed());

        //ReusableMethods.getScreenshot("US02_TC01 ");
        Driver.closeDriver();

    }
}
