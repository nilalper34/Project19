package tests.US_0012;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.yaseminpgc;
import utilities.Driver;
import utilities.yaseminmethod;

import java.io.IOException;

public class TC_004 {
    public TC_004() throws IOException {
    }

    yaseminpgc yaseminpgc=new yaseminpgc();
    yaseminmethod yaseminmethod=new yaseminmethod();
    @Test
    public void test04() throws InterruptedException, IOException {
        yaseminmethod.ilk();
        //Store manager olarak hesabıma gidince tum portal a access elde etmeliyim  "Hesap Detaylarını update edebilir
        /*
        1-vendor https://hubcomfy.com/ adersine gider
        2-vendor sign-in e tıklar
        3-vendor açılan pencereden sign_ini seçer
        4-vendor username alanına valid bir username girer
        5-vendor password alanına valid bir password girer
        6-Sign in butonuna tıklar
       7-vendor olarak basarılı giriş yaptıgını dogrular
       8-vendor sayfanın aşagısında bulunan "Orders,Address,Downloads,Account Details,Wishılıst ve Logout u" görür
       9-" Account details" secenegini tıklayarak hesap detaylarını görür ve update eder
      */


Actions actions=new Actions(Driver.getDriver());
        //   8-vendor sayfanın aşagısında bulunan "Orders,Address,Downloads,Account Details,Wishılıst ve Logout u" görür
        for (int i = 0; i <= 9; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }

        Assert.assertTrue( yaseminpgc.ordersButonu.isDisplayed());
        Assert.assertTrue(yaseminpgc.AccountButonu.isDisplayed());
        Assert.assertTrue( yaseminpgc.downloandsButonu.isDisplayed());
        Assert.assertTrue(  yaseminpgc.logoutButonu.isDisplayed());
        Assert.assertTrue( yaseminpgc.addresesButonu.isDisplayed());
        Assert.assertTrue(  yaseminpgc.WishlistButonu.isDisplayed());

  //  9-" Account details" secenegini tıklayarak hesap detaylarını görür ve update eder
        yaseminpgc.AccountButonu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(yaseminpgc.savechangeButonu.isEnabled());

Driver.closeDriver();




    }
}
