package tests.US_12;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.yaseminpgc;
import utilities.Driver;
import utilities.yaseminmethod;

import java.io.IOException;

public class TC_003 {
    yaseminpgc yaseminpgc = new yaseminpgc();

    public TC_003() throws IOException {
    }
    //Store manager olarak hesabıma gidince tum portal a access elde etmeli
    // "Addreses bölümüne gidip fatura ve gönderim adrresini update edebilmeli"

    /*
    1-vendor https://hubcomfy.com/ adersine gider
2-vendor sign-in e tıklar
3-vendor açılan pencereden sign_ini seçer
4-vendor username alanına valid bir username girer
5-vendor password alanına valid bir password girer
6-Sign in butonuna tıklar ve giriş başarılı yazısını görür
7-vendor olarak basarılı giriş yaptıgını dogrular
8-vendor sayfanın aşagısında bulunan "Orders,Address,Downloads,Account Details,Wishılıst ve Logout u" görür
9-"Addresses" secenegini tıklayarak fatura adresi ve gönderim adresini görür ve sırasıyla update eder
*/
yaseminmethod yaseminmethod=new yaseminmethod();
    @Test
    public void test03() throws InterruptedException, IOException {
        yaseminmethod.ilk();

        Actions actions=new Actions(Driver.getDriver());
        //   8-vendor sayfanın aşagısında bulunan "Orders,Address,Downloads,Account Details,Wishılıst ve Logout u" görür
        for (int i = 0; i <= 9; i++) {

            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }

        //9-"Addresses" secenegini tıklayarak fatura adresi ve gönderim adresini görür ve sırasıyla update eder
          //fatura adresi
        yaseminpgc.addresesButonu.click();
     actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(yaseminpgc.faturaadresiedit.isEnabled());
        //gönderim adresi
        yaseminpgc.addresesButonu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(yaseminpgc.gönderimadresi.isEnabled());


    }
}