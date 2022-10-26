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

public class US01_TC06 {
    @Test
    public void test06() throws IOException {
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
        MustafaMethods.getEmailCode();     //4. ve 5. madde burada birlikte methoddan cagrilmistir
        //  6- Kucuk harf, buyuk harf, rakam ve ozel karakterlerden olusan bir password girer
        mustafaPgc.passwordKutusu.sendKeys("Qwerty*123");
        //  7- Aynı passwordu confirm password kutusuna da girer
        mustafaPgc.confirmPasswordKutusu.sendKeys("Qwerty*123");

        //  8- Register butonuna tıklar
        jse.executeScript("arguments[0].scrollIntoView(true);", mustafaPgc.register2Buton);
        jse.executeScript("arguments[0].click();", mustafaPgc.register2Buton);

        //  9- Passwordun kabul edilip sisteme basarili giris yapildigini test eder
        ReusableMethods.waitFor(3);
        String actualSonuc = mustafaPgc.welcomeToHubcomfyText.getText();
        String expectedSonuc = "Welcome to Hubcomfy!";
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));

        //ReusableMethods.getScreenshot("US01_TC06 ");
        Driver.quitDriver();


    }
}
