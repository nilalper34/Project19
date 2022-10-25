package tests.US_01;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MustafaPgc;
import utilities.MustafaMethods;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US01_TC05 {
    @Test
    public void test05() throws IOException {
        MustafaPgc mustafaPgc = new MustafaPgc();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        //   1- Kullanici https://hubcomfy.com/ url adresine gider
        Driver.getDriver().get("https://hubcomfy.com/");
        //   2- Register yazisina tiklar
        mustafaPgc.register.click();
        //   3- Become a vendor yazisinin uzerine tiklar
        mustafaPgc.becomeAVendor.click();
        //   4- Email kutusuna unique gecerli bir email girer
        mustafaPgc.emailKutusu.sendKeys("proje1981@yahoo.com");
        mustafaPgc.verificationCodeKutusu.click();
        //   5- Email adresine gelen Verification Code ilgili kutuya girer
        MustafaMethods.registeredGetEmailCode();

        //   6- Gecerli password girer
        mustafaPgc.passwordKutusu.sendKeys("qwerty123");
        //   7- Aynı passwordu confirm password kutusuna da girer
        mustafaPgc.confirmPasswordKutusu.sendKeys("qwerty123");
        //   8- Register butonuna tıklar
        jse.executeScript("arguments[0].scrollIntoView(true);", mustafaPgc.register2Buton);
        jse.executeScript("arguments[0].click();", mustafaPgc.register2Buton);

        //   9- Aynı email adresi ile tekrar register yapilamayacagini test eder
        ReusableMethods.waitFor(3);
        String expectedError = "This Email already exists. Please login to the site and apply as vendor.";
        Assert.assertTrue(mustafaPgc.emailExistsError.getText().contains(expectedError));

        //ReusableMethods.getScreenshot("US01_TC05 ");

        Driver.quitDriver();
    }
}
