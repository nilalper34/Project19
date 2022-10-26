package tests.US_13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RecepPage;

import utilities.ConfigReader;
import utilities.Driver;

public class testCase_3 {
    @DataProvider
    public static Object[][] kullanicilar() {
        return new Object[][]{{"recepdaricibozkaya@gmail.com", "darici4507"}};
    }

    @Test(dataProvider = "kullanicilar")
    public void test01(String userEmail, String password) throws InterruptedException {
        //    1- Kullanici https://hubcomfy.com/ url adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        //    2-Sign in butonuna tıklar
        RecepPage hubc=new RecepPage();
        hubc.hubcSignIn.click();
        //    3-Username or email address  ve Password kutucuklarına geçerli bilgileri girer ve Sign in butonuna tıklar
        hubc.userEmail.sendKeys(userEmail);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(password)
                .sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        //    4-Açılan sayfanin en altındaki My Account yazısına tıklar
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        hubc.myAccound.click();

        //    5- My Account sayfasına gider ve  My Account yazısının görünür olduğunu test eder
        //    6- My Account sayfasındaki Store Manager butonuna tıklar
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        hubc.storManager.click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //    7-Store Manager sayfasina gider ve Store Manager yazısının görünür olduğunu test eder
        //    8- Store Manager sayfasındaki  coupons butonuna tıklar
        Thread.sleep(3000);
        hubc.coupons.click();
        //    9-Coupons sayfasında Add New butonuna tıklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        hubc.addNew.click();
        //  10-Discount Type bölümünden indirim türünü seçer
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        hubc.discount_type.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        hubc.discount_type.click();




    }
}