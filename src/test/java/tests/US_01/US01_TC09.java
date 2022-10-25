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

public class US01_TC09 {
    @Test
    public void test09() throws IOException {
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
        //  5- Email adresine gelen Verification Code ilgili kutuya girer
        MustafaMethods.getEmailCode();     // 4. ve 5. maddeler bu metohdla birlikte getirildi
        ReusableMethods.waitFor(2);
        //  6- Gecerli bir password girer
        mustafaPgc.passwordKutusu.sendKeys("Qwerty*123");
        //  7- Confirm password kutusuna farkli bir password girer
        mustafaPgc.confirmPasswordKutusu.sendKeys("Qwerty*123");
        //  8- Register butonuna tıklar

        jse.executeScript("arguments[0].scrollIntoView(true);", mustafaPgc.register2Buton);
        jse.executeScript("arguments[0].click();", mustafaPgc.register2Buton);
        //  9- Sistem basarili bir giris yapilabildigini test eder

        String actualSonuc = mustafaPgc.welcomeToHubcomfyText.getText();
        String expectedSonuc = "Welcome to Hubcomfy!";
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));

        //ReusableMethods.getScreenshot("US01_TC09 ");
        Driver.quitDriver();
        //Registration Successfully Completed.
    }
}
