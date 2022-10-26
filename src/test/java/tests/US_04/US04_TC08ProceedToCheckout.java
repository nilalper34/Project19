package tests.US_04;

import jdk.jfr.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;
import pages.Erhanpgc;
import utilities.Driver;
import utilities.ReusableMethods;

//1. Vendor url'ye adresine gider
//        2. Vendor signin butonuna tıklar
//        3. Vendor gecerli bir username girer
//        4. Vendor gecerli bir password girer
//        5. Vendor sign in butonuna basar
//        6. Vendor sign out butonuna basar
//        7. Vendor Orders butonuna basar
//        8. Vendor go to shop'a tıklar
//        9. Vendor 2 adet ürün secip tek tek sepete ekler
//        10. Vendor cart'a tıklar
//        11. Vendor wiew Cart'a tıklar
//        12. Vendor proceed to checkout'a tıklar
//        13. Vendor adres bilgileri kismina Miami girer

public class US04_TC08ProceedToCheckout  {
    public static SoftAssert softAssert = new SoftAssert();
    public static Actions actions = new Actions(Driver.getDriver());
    public static JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    public static Erhanpgc erhanpgc = new Erhanpgc();



    @Test(priority = 8)
    public void tc08_ProceedToCheckout() throws InterruptedException {

        //Vendor sign in yapar
        US02_TC01ValidSignIn.ValidSignInVendor();

        //6. Vendor  my account butonuna basar
        jse.executeScript("arguments[0].scrollIntoView(true);", erhanpgc.myAccountLink);
        jse.executeScript("arguments[0].click();", erhanpgc.myAccountLink);

        //7. Vendor  Orders butonuna basar
        erhanpgc.ordersLink.click();

        //8. Vendor  BROWSE PRODUCTS'a tıklar
        try {
            erhanpgc.browseProductsLink.click();
        } catch (Exception e) {
            jse.executeScript("arguments[0].scrollIntoView(true);", erhanpgc.goShopButton);
            jse.executeScript("arguments[0].click();", erhanpgc.goShopButton);
        }
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("shop"), "Check shop page link");

        //9. Vendor 2 adet ürün secip tek tek sepete ekler
        actions.moveToElement(erhanpgc.avaliableItemsInStock.get(0)).click().perform();
        Thread.sleep(1000);
        actions.moveToElement(erhanpgc.avaliableItemsInStock.get(1)).click().perform();
        Thread.sleep(1000);

        //10. Vendor cart'a tıklar
       //11. Vendor wiew Cart'a tıklar
        jse.executeScript("arguments[0].scrollIntoView(true);", erhanpgc.cartLink);
        jse.executeScript("arguments[0].click();", erhanpgc.cartLink);
        ReusableMethods.waitForClickablility(erhanpgc.viewCartButton,1);
        erhanpgc.viewCartButton.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("cart"), "Check Cart page");

        //12. Vendor proceed to checkout'a tıklar
        jse.executeScript("arguments[0].scrollIntoView(true);", erhanpgc.proceedToCheckoutButton);
        jse.executeScript("arguments[0].click();", erhanpgc.proceedToCheckoutButton);

        System.out.println(erhanpgc.billingCityBox.getAttribute("value"));


       softAssert.assertTrue(erhanpgc.billingCityBox.isDisplayed());
       softAssert.assertTrue(erhanpgc.billingCityBox.getAttribute("value").contains("miami"));

       Driver.getDriver().quit();


    }
}
