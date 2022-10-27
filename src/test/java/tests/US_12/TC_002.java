package tests.US_12;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.yaseminpgc;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.yaseminmethod;

import java.io.IOException;

public class TC_002 {


    yaseminpgc yaseminpgc = new yaseminpgc();

    public TC_002() throws IOException {
    }
yaseminmethod yaseminmethod=new yaseminmethod();
    //Store manager olarak hesabıma gidince tum portal a access elde etmeli  "Download olan rünleri listeleyebilmeli"

    /* 1-vendor https://hubcomfy.com/ adersine gider
  2-vendor sign-in e tıklar
 3-vendor açılan pncereden sign_ini seçer
 4-vendor username alanına valid bir username girer
 5-vendor password alanına valid bir password girer
6-Sign in butonuna tıklar
7-vendor olarak basarılı giriş yaptıgını dogrular
8-vendor sayfanın aşagısında bulunan "Orders,Address,Downloads,Account Details,Wishılıst ve Logout u" görür
9-- "Downloads" sekmesine tıklar ve indirdiği ürünleri görür

    */

    @Test
    public void test02() throws InterruptedException, IOException {

        //  1-vendor https://hubcomfy.com/ adersine gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));

        //  2-Giriş simgesine tıklar
        yaseminpgc.ilkSign_inButonu.click();

        //3-Username alanına valid bir username girer
        yaseminpgc.usurname.sendKeys(ConfigReader.getProperty("hbcValidUserMailErhan"));

        // 4-Password alanına valid bir password girer
        yaseminpgc.password.sendKeys(ConfigReader.getProperty("hbcValidPasswordErhan"));

        // 5-Sign in butonuna tıklar
        yaseminpgc.ikinciSign_inButonu.click();


        // 6-vendor olarak basarılı giriş yaptıgını dogrular
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(7000);
        //  7-sign out sekmesini tıklar
        yaseminpgc.sign_inOutButonu.click();

        //   8-vendor sayfanın aşagısında bulunan "Orders,Address,Downloads,Account Details,Wishılıst ve Logout u" görür
        for (int i = 0; i <= 9; i++) {

            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }

    //9- "Downloads" sekmesine tıklar ve indirdiği ürünleri görür
        yaseminpgc.downloandsButonu.click();
      Assert.assertTrue(yaseminpgc.dosyaismi.isDisplayed());

      Driver.closeDriver();
    }

}