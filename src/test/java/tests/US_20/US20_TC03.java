package tests.US_20;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.hayrullahpgc;
import utilities.ConfigReader;
import utilities.Driver;

public class US20_TC03 {
    hayrullahpgc hayrullahpgc = new hayrullahpgc();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void us20_tc03 () throws InterruptedException {
        //1- Vendor https://hubcomfy.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));

        //2- Vendor sign in butonuna tıklar
        hayrullahpgc.singInButtonMainPage.click();

        //3- Vendor gecerli email adresini girer
        Thread.sleep(2000);
        hayrullahpgc.userNameBox.sendKeys(ConfigReader.getProperty("emailhd"));

        //4- Vendor gecerli password girer
        hayrullahpgc.passwordBox.sendKeys(ConfigReader.getProperty("passwordhd"));

        //5- Vendor "Sign In" butonuna tiklar
        hayrullahpgc.getSingInButtonLogIn.click();

        //6- Vendor giris yaptigini dogrular
        Thread.sleep(2000);
        Assert.assertTrue(hayrullahpgc.signOutButton.isDisplayed());

        //7- Vendor "My Account" a tiklar
        for (int i = 1; i <6 ; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }
        Thread.sleep(2000);

        hayrullahpgc.myAccount.click();

        //8-  Vendor "Store Manager" a tiklar
        hayrullahpgc.storeManeger.click();

        //9- Vendor"Reviews" e tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        hayrullahpgc.reviews.click();

        //10- Vendor "Product Reviews" e tiklar
        hayrullahpgc.productReviews.click();

        //11- Vendor yorum yapanlarin oylarinin gorundugunu dogrular
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(hayrullahpgc.rating.isDisplayed());

        Driver.closeDriver();

    }
}
