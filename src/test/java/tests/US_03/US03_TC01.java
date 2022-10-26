package tests.US_03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.hayrullahpgc;
import utilities.ConfigReader;
import utilities.Driver;

public class US03_TC01 {
    hayrullahpgc hayrullahpgc = new hayrullahpgc();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void us03_tc01() throws InterruptedException {

        //1. Vendor  url  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));

        //2. Vendor  signin butonuna tıklar
        hayrullahpgc.singInButtonMainPage.click();

        //3. Vendor  gecerli bir email girer
        Thread.sleep(2000);
        hayrullahpgc.userNameBox.sendKeys(ConfigReader.getProperty("email01hd"));

        //4. Vendor  gecerli bir password girer
        hayrullahpgc.passwordBox.sendKeys("TtS3WAVty4sPPbr");

        //5. Vendor  sign in butonuna basar
        hayrullahpgc.getSingInButtonLogIn.click();

        //6. Vendor  my account butonuna basar
        Thread.sleep(2000);
        jse.executeScript("arguments[0].scrollIntoView(true);", hayrullahpgc.myAccount);
        jse.executeScript("arguments[0].click();", hayrullahpgc.myAccount);

        //7. Vendor  Orders butonuna basar
        hayrullahpgc.orders.click();

        //8. Vendor  BROWSE PRODUCTS'a tıklar

        hayrullahpgc.browseProducts.click();






    }
}
