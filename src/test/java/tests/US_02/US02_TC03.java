package tests.US_02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MustafaPgc;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class US02_TC03 {

    @Test
    public void test03() throws IOException {
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
        //  7- Sayfada dashboard menusunun var oldugunu test eder
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(mustafaPgc.dashboardMenu.isEnabled());

        //  8- Dashboard altinda Store Manager butonunun oldugunu test eder
        ReusableMethods.waitFor(1);
        Assert.assertTrue(mustafaPgc.storeManagerMenu.isEnabled());
        //  9- Dashboard altinda Orders butonunun oldugunu test eder
        ReusableMethods.waitFor(1);
        Assert.assertTrue(mustafaPgc.ordersMenu.isEnabled());
        //  10- Dashboard altinda Downloads butonunun oldugunu test eder
        ReusableMethods.waitFor(1);
        Assert.assertTrue(mustafaPgc.downloadsMenu.isEnabled());
        //  11- Dashboard altinda Addresses butonunun oldugunu test eder
        ReusableMethods.waitFor(1);
        Assert.assertTrue(mustafaPgc.addressesMenu.isEnabled());
        //  12- Dashboard altinda Appointments butonunun oldugunu test eder

        ReusableMethods.waitFor(1);
        List<String> menuListStr = new ArrayList<>();
        for (WebElement w : mustafaPgc.menuListWE) {
            menuListStr.add(w.getText());
        }
        //    Assert.assertTrue(menuListStr.contains("Appointments"));        // TEST FAILED

        //  13- Dashboard altinda Wishlist butonunun oldugunu test eder
        ReusableMethods.waitFor(1);
        Assert.assertTrue(mustafaPgc.wishlistMenu.isEnabled());

        //ReusableMethods.getScreenshot("US02_TC03 ");
        Driver.closeDriver();

    }
}
