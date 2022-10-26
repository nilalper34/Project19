package tests.US_04;

//1. Vendor url'ye adresine gider
//        2. Vendor signin butonuna tıklar
//        3. Vendor gecerli bir username girer
//        4. Vendor gecerli bir password girer
//        5. Vendor sign in butonuna basar
//        6. Vendor cart'a tıklar
//        7. Vendor view Cart'a tıklar
//        8. Vendor clear cart'a tıklar

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.Erhanpgc;

import utilities.Driver;

public class US04_TC04ClearCart {
        public static Erhanpgc erhanpgc = new Erhanpgc();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void tc04_ClearCart() throws InterruptedException {
        US04_TC01AddFiveItems.tc01AddFiveItems();

        jse.executeScript("arguments[0].scrollIntoView(true);", erhanpgc.clearCartButton);
        jse.executeScript("arguments[0].click();", erhanpgc.clearCartButton);

        Driver.getDriver().quit();
    }
}
