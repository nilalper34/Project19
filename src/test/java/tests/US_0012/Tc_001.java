package tests.US_0012;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.yaseminpgc;
import utilities.Driver;
import utilities.yaseminmethod;

import java.io.IOException;

public class Tc_001  {
    yaseminpgc yaseminpgc = new yaseminpgc();
    yaseminmethod yaseminmethod=new yaseminmethod();

    public Tc_001() throws IOException {
    }

    @Test
    public void test01() throws IOException, InterruptedException {

   // TC_001 Store manager olarak hesabıma gidince tum portal a access elde etmeliyim "Ordersları listeleyebilmeli"

        /*
    1-vendor https://hubcomfy.com/ adersine gider
   2-Giriş simgesine tıklar
  3-Username alanına valid bir username girer
  4-Password alanına valid bir password girer
  5-Sign in butonuna tıklar
  6-vendor olarak basarılı giriş yaptıgını dogrular
  7-sign out sekmesini tıklar
  8-vendor sayfanın aşagısında bulunan "Orders,Address,Downloads,Account Details,Wishılıst ve Logout u" görür
 9-"Orders'a" tıklar ve siparişlerinin listelendiğini görür
     */


      yaseminmethod.ilk();

        //   8-vendor sayfanın aşagısında bulunan "Orders,Address,Downloads,Account Details,Wishılıst ve Logout u" görür
        for (int i = 0; i <= 9; i++) {
            Actions actions=new Actions(Driver.getDriver());
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }

       Assert.assertTrue( yaseminpgc.ordersButonu.isDisplayed());
        Assert.assertTrue(yaseminpgc.AccountButonu.isDisplayed());
       Assert.assertTrue( yaseminpgc.downloandsButonu.isDisplayed());
      Assert.assertTrue(  yaseminpgc.logoutButonu.isDisplayed());
       Assert.assertTrue( yaseminpgc.addresesButonu.isDisplayed());
      Assert.assertTrue(  yaseminpgc.WishlistButonu.isDisplayed());

    // 9-"Orders'a" tıklar ve siparişlerinin listelendiğini görür
        yaseminpgc.ordersButonu.click();
         Assert.assertTrue(yaseminpgc.viewButonu.isDisplayed());

         Driver.closeDriver();
    }

}
