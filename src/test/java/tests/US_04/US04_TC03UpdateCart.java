package tests.US_04;

//1. Vendor url'ye adresine gider
//2. Vendor signin butonuna tıklar
//3. Vendor gecerli bir username girer
//4. Vendor gecerli bir password girer
//5. Vendor sign in butonuna basar
//6. Vendor cart'a tıklar
//7. Vendor view Cart'a tıklar
//8. Vendor ikinci urunun miktarını 100 arttirir
//9. Vendor updateCart'a tıklar

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.Erhanpgc;

import utilities.Driver;

public class US04_TC03UpdateCart {

    Actions actions = new Actions(Driver.getDriver());
    static JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    public static Erhanpgc erhanpgc = new Erhanpgc();

    @Test(priority = 2)
    public static void tc03UpdateCart() throws InterruptedException {
        US04_TC01AddFiveItems.tc01AddFiveItems();
        Driver.getDriver().navigate().refresh();

//8. Vendor ikinci urunun miktarını 100 arttirir
//9. Vendor updateCart'a tıklar
        for (int i = 0; i < 100; i++) {
            erhanpgc.plusButtons.get(1).click();
            erhanpgc.plusButtons.get(2).click();
            Thread.sleep(500);
        }

        jse.executeScript("arguments[0].scrollIntoView(true);", erhanpgc.updateCartButton);
        jse.executeScript("arguments[0].click();", erhanpgc.updateCartButton);


    }
}
