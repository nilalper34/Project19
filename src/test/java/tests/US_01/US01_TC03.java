package tests.US_01;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MustafaPgc;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US01_TC03 {
    @Test
    public void test03() throws InterruptedException, IOException {

        MustafaPgc mustafaPgc = new MustafaPgc();
        Actions actions = new Actions(Driver.getDriver());

        //   1- Kullanici https://hubcomfy.com/ url adresine gider
        Driver.getDriver().get("https://hubcomfy.com/");
        //   2- Register yazisina tiklar
        mustafaPgc.register.click();
        //   3- Become a vendor yazisinin uzerine tiklar
        mustafaPgc.becomeAVendor.click();
        //   4- Email kutusunu boş bırakir
        //   5- Bir password girer
        mustafaPgc.passwordKutusu.sendKeys("Qwer.1234");
        //   6- Aynı passwordu confirm password kutusuna da girer
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.TAB).sendKeys("Qwer.1234").perform();
        //   7- Register butonuna tıklar
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        //  8- Email girilmeden register yapilamayacagini test eder
        Assert.assertTrue(mustafaPgc.emailGerekliYazisi.isDisplayed());    // Email: This field is required.

        //ReusableMethods.getScreenshot("US01_TC03");

        Driver.closeDriver();
    }
}
