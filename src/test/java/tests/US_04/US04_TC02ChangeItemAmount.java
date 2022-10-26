package tests.US_04;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
//        6. Vendor cart'a tıklar
//        7. Vendor view Cart'a tıklar
//        8. Vendor ilk urunun miktarını 1arttırır
//        9. Vendor ilk urunun miktarını 1 azaltır

public class US04_TC02ChangeItemAmount  {

    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    SoftAssert softAssert = new SoftAssert();
    public static Erhanpgc erhanpgc = new Erhanpgc();

    @Test( priority = 4)


    public void tc02ChangeItemAmounts() throws InterruptedException {
        //Vendor sign in yapar
        US02_TC01ValidSignIn.ValidSignInVendor();
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

        //9. Vendor 5 adet ürün secip tek tek sepete ekler
        actions.moveToElement(erhanpgc.avaliableItemsInStock.get(0)).click().perform();
        Thread.sleep(1000);
        actions.moveToElement(erhanpgc.avaliableItemsInStock.get(1)).click().perform();
        Thread.sleep(1000);
        actions.moveToElement(erhanpgc.avaliableItemsInStock.get(2)).click().perform();
        Thread.sleep(1000);
        try {
            actions.moveToElement(erhanpgc.avaliableItemsInStock.get(3)).click().perform();
        } catch (Exception e) {
            jse.executeScript("arguments[0].scrollIntoView(true);", erhanpgc.avaliableItemsInStock.get(3));
            jse.executeScript("arguments[0].click();", erhanpgc.avaliableItemsInStock.get(3));
        }
        Thread.sleep(1000);
        jse.executeScript("arguments[0].scrollIntoView(true);", erhanpgc.avaliableItemsInStock.get(4));
        jse.executeScript("arguments[0].click();", erhanpgc.avaliableItemsInStock.get(4));
        Thread.sleep(2000);
        Driver.getDriver().navigate().refresh();
        softAssert.assertEquals(Integer.parseInt(erhanpgc.countOfItemsInCart.getText()), 5,
                "Check number of Items in Cart");

        //10. Vendor cart'a tıklar
        //11. Vendor view Cart'a tıklar
        jse.executeScript("arguments[0].scrollIntoView(true);", erhanpgc.cartLink);
        jse.executeScript("arguments[0].click();", erhanpgc.cartLink);
        ReusableMethods.waitForClickablility(erhanpgc.viewCartButton,1);
        erhanpgc.viewCartButton.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("cart"), "Check Cart page");

        //12. Vendor ilk urunun miktarını 1arttırır

        erhanpgc.plusButtons.get(0).click();
       jse.executeScript("arguments[0].scrollIntoView(true);", erhanpgc.updateCartButton);
       jse.executeScript("arguments[0].click();", erhanpgc.updateCartButton);
        Thread.sleep(2000);
       actions.sendKeys(Keys.PAGE_UP);
       actions.sendKeys(Keys.PAGE_UP);
        Thread.sleep(5000);
       System.out.println(erhanpgc.plusButtons.get(0).getCssValue("value").contains("2"));

        //13. Vendor ilk urunun miktarını 1 azaltır
        ReusableMethods.waitForClickablility(erhanpgc.firstMinusButton,3);

        jse.executeScript("arguments[0].scrollIntoView(true);", erhanpgc.firstMinusButton);
        jse.executeScript("arguments[0].click();", erhanpgc.firstMinusButton);
        Thread.sleep(1000);

        jse.executeScript("arguments[0].scrollIntoView(true);", erhanpgc.updateCartButton);
        jse.executeScript("arguments[0].click();", erhanpgc.updateCartButton);

        Driver.getDriver().quit();

        }

}

