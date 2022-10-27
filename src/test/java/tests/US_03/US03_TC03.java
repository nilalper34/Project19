package tests.US_03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.hayrullahpgc;
import utilities.ConfigReader;
import utilities.Driver;

public class US03_TC03 {


    hayrullahpgc hayrullahpgc = new hayrullahpgc();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void us03_tc03() throws InterruptedException {

        //1. Vendor  url  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));

        //2. Vendor  signin butonuna tıklar
        hayrullahpgc.singInButtonMainPage.click();

        //3. Vendor  gecerli bir email girer
        Thread.sleep(2000);
        hayrullahpgc.userNameBox.sendKeys(ConfigReader.getProperty("emailhd"));

        //4. Vendor  gecerli bir password girer
        hayrullahpgc.passwordBox.sendKeys(ConfigReader.getProperty("passwordhd"));

        //5. Vendor  sign in butonuna basar

        hayrullahpgc.getSingInButtonLogIn.click();

        //6. Vendor  sepete tıklar
        Thread.sleep(2000);
        hayrullahpgc.sepet.click();

        //7. Vendor  checkout a tıklar
        Thread.sleep(2000);
        hayrullahpgc.checkout.click();


    }
}
