package tests.US_04;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Erhanpgc;
import utilities.Driver;
import utilities.ReusableMethods;

//1. Vendor  url  adresine gider
//2. Vendor  signin butonuna tıklar
//3. Vendor  gecerli bir username girer
//4. Vendor  gecerli bir password girer
//5. Vendor  sign in butonuna basar
//6. Vendor  my account butonuna basar
//7. Vendor  Orders butonuna basar
//8. Vendor  BROWSE PRODUCTS'a tıklar
//9. Vendor 5 adet ürün secip tek tek sepete ekler
//10. Vendor cart'a tıklar
//11. Vendor view Cart'a tıklar
//12. Urunler rakam, miktar ve toplam olarak goruntulenir


public class US04_TC01AddFiveItems {

    public static SoftAssert softAssert = new SoftAssert();
    public static Actions actions = new Actions(Driver.getDriver());
    public static JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    public static Erhanpgc erhanpgc = new Erhanpgc();

    @Test(priority = 1)
    public static void tc01AddFiveItems() throws InterruptedException {
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
        Thread.sleep(1000);
        Driver.getDriver().navigate().refresh();
        softAssert.assertTrue(Integer.parseInt(erhanpgc.countOfItemsInCart.getText())<= 5,
                "Check number of Items in Cart");
        //Assert.assertTrue(Integer.parseInt(erhanpgc.countOfItemsInCart.getText())<= 5,
                //"Check number of Items in Cart"); Hard assert

        //10. Vendor cart'a tıklar
        //11. Vendor view Cart'a tıklar
        jse.executeScript("arguments[0].scrollIntoView(true);", erhanpgc.cartLink);
        jse.executeScript("arguments[0].click();", erhanpgc.cartLink);
        ReusableMethods.waitForClickablility(erhanpgc.viewCartButton,1);
        erhanpgc.viewCartButton.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("cart"), "Check Cart page");

        //12. Urunler fiyat, miktar ve toplam olarak goruntulenir
        boolean itemTag = false;
        boolean itemAmount = false;
        boolean itemSubtotal = false;
        for (int i = 0; i < erhanpgc.itemPriceTags.size(); i++) {
            itemTag = erhanpgc.itemPriceTags.get(i).isDisplayed();
            itemAmount = erhanpgc.itemAmounts.get(i).isDisplayed();
            itemSubtotal = erhanpgc.itemSubtotals.get(i).isDisplayed();
        }
        Assert.assertTrue(itemTag,"Check item tags");
        Assert.assertTrue(itemAmount,"Check item amounts");
        Assert.assertTrue(itemSubtotal,"Check item subtotals");

        softAssert.assertAll("Ceheck item numbers");

    }
}




























   /* @Test(dependsOnMethods = "us_004BrowseProducts",priority = 2)
    public void us_004SelectFiveProducts() throws InterruptedException {
        actions.moveToElement(erhanpgc.avaliableItemsInStock.get(0)).click().perform();
        Thread.sleep(1000);
        actions.moveToElement(erhanpgc.avaliableItemsInStock.get(1)).click().perform();
        Thread.sleep(1000);
        actions.moveToElement(erhanpgc.avaliableItemsInStock.get(2)).click().perform();
        Thread.sleep(1000);
        actions.moveToElement(erhanpgc.avaliableItemsInStock.get(3)).click().perform();
        Thread.sleep(1000);
        actions.moveToElement(erhanpgc.avaliableItemsInStock.get(3)).click().perform();
        Thread.sleep(1000);
        Driver.getDriver().navigate().refresh();
        Assert.assertEquals(Integer.parseInt(erhanpgc.countOfItemsInCart.getText()), 5, "Check number of Items in Cart");
        Driver.getDriver().navigate().refresh();
        erhanpgc.cartLink.click();
        erhanpgc.viewCartButton.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("cart"),"Check Cart page");
      }*/

//6. Vendor  sepete tıklar
//7. Vendor  checkout a tıklar
   /* @Test(dependsOnMethods = "us_004SelectFiveProducts")
    public void us_004CartCheckout() {
        Driver.getDriver().navigate().refresh();
        erhanpgc.cartLink.click();
        erhanpgc.viewCartButton.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("cart"),"Check Cart page");
        jse.executeScript("arguments[0].scrollIntoView(true);",erhanpgc.checkoutButton);
        jse.executeScript("arguments[0].click();",erhanpgc.checkoutButton);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("checkout-2"),"Check checkout Address Link");
    }*/

//9. Vendor 5 adet ürün secip tek tek sepete ekler
//10. Vendor cart'a tıklar
//11. Vendor view Cart'a tıklar
//12. Urunler rakam, miktar ve toplam olarak goruntulenir







