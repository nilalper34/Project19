package tests.US_01;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MustafaPgc;
import utilities.MustafaMethods;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US01_TC10 {
    @Test
    public void test10() throws IOException {
        MustafaPgc mustafaPgc = new MustafaPgc();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        //  1- Kullanici https://hubcomfy.com/ url adresine gider
        Driver.getDriver().get("https://hubcomfy.com/");
        //  2- Register yazisina tiklar
        mustafaPgc.register.click();
        //  3- Become a vendor yazisinin uzerine tiklar
        mustafaPgc.becomeAVendor.click();
        //  4- Email alanina gecerli bir email girer
        //  5- Verification Code kutusu bos birakilir
        MustafaMethods.getEmailCode();     //4. ve 5. madde burada birlikte methoddan cagrilmistir
        ReusableMethods.waitFor(2);
        mustafaPgc.verificationCodeKutusu.clear();
        ReusableMethods.waitFor(2);

        //  6- Gecerli bir password girer
        mustafaPgc.passwordKutusu.sendKeys("Qwerty*123");
        //  7- Confirm password kutusuna farkli bir password girer
        mustafaPgc.confirmPasswordKutusu.sendKeys("Qwerty*123");
        //  8- Verification Code girilmeden register tusuna tıklar

        jse.executeScript("arguments[0].scrollIntoView(true);", mustafaPgc.register2Buton);
        jse.executeScript("arguments[0].click();", mustafaPgc.register2Buton);

        //  9- Verification Code girilmeden register isleminin yapilamadigini test eder
        ReusableMethods.waitFor(2);

        ReusableMethods.waitFor(1);
        Assert.assertTrue(mustafaPgc.verificationCodeGerekliYazisi.isDisplayed());
        //"Email Verification Code: This field is required."

        //ReusableMethods.getScreenshot("US01_TC10 ");
        Driver.quitDriver();
    }
}
