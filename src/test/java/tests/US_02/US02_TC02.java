package tests.US_02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MustafaPgc;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US02_TC02 {
    @Test
    public void test02() throws IOException {
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
        ReusableMethods.waitFor(2);
        mustafaPgc.signIn2butonu.click();
        //  6- Signout butonunun solundaki simgeyi veya sayfanin sonundaki My Accountu tiklar
        ReusableMethods.waitFor(3);
        mustafaPgc.myAccountSimge.click();
        //  7- Gelen sayfada Orders menusunun var oldugunu test eder
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(mustafaPgc.orders.isEnabled());
        //  8- Gelen sayfada Downloads menusunun var oldugunu test eder
        ReusableMethods.waitFor(1);
        Assert.assertTrue(mustafaPgc.downloads.isEnabled());
        //  9- Gelen sayfada Adresses menusunun var oldugunu test eder
        ReusableMethods.waitFor(1);
        Assert.assertTrue(mustafaPgc.addresses.isEnabled());
        //  10- Gelen sayfada Account Details menusunun var oldugunu test eder
        ReusableMethods.waitFor(1);
        Assert.assertTrue(mustafaPgc.accountDetails.isEnabled());
        //  11- Gelen sayfada Wishlist menusunun var oldugunu test eder
        ReusableMethods.waitFor(1);
        Assert.assertTrue(mustafaPgc.wishlist.isEnabled());
        //  12- Gelen sayfada Logout butonunun var oldugunu test eder
        ReusableMethods.waitFor(1);
        Assert.assertTrue(mustafaPgc.logout.isEnabled());

        //ReusableMethods.getScreenshot("US02_TC02 ");

        Driver.closeDriver();

    }
}
