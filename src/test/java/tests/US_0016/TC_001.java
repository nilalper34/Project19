package tests.US_0016;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.yaseminpgc;
import utilities.Driver;
import utilities.yaseminmethod;

import java.io.IOException;

public class TC_001 {
    public TC_001() throws IOException {
    }

    yaseminpgc yaseminpgc=new yaseminpgc();
yaseminmethod yaseminmethod=new yaseminmethod();
    /*
    TC_001 My Account sekmesine tıklayarak customer menüsüne erişebilmeli
    kayıtlı müşterilerin name/usurname/email/harcama miktarı/son siparişleri görebilmeli
     */

    /*
    1-vendor https://hubcomfy.com/ adersine gider
    2-Giriş simgesine tıklar
    3-Açılan pncereden sign_in simgesine tıklar
    4-Username alanına valid bir username girer
    5-Password alanına valid bir password girer
    6-Sign in butonuna tıklar
    7-sign out sekmesini tıklar
    8-Store manager sekmesine tıklar ve customer menüse erişir
    9-kayıtlı müşterilerin name/usurname/email/harcama miktarı/son siparişlerini görebilir
*/

    @Test
    public void test01() throws InterruptedException, IOException {
        yaseminmethod.ilk();
       Actions actions=new Actions(Driver.getDriver());
       // 8-Store manager sekmesine tıklar ve customer menüse erişir
      yaseminpgc.storemanagermenu.click();
      actions.sendKeys(Keys.PAGE_DOWN).perform();
      Thread.sleep(1000);
        Assert.assertTrue( yaseminpgc.customersMenu.isDisplayed());
        yaseminpgc.customersMenu.click();

      // 9-kayıtlı müşterilerin name/usurname/email/harcama miktarı/son siparişlerini görebilir
        WebElement baslik[]={yaseminpgc.basliklastorders,yaseminpgc.baslikemail,yaseminpgc.basliklactions,
                yaseminpgc.basliklastname,yaseminpgc.baslikmoneyspent,yaseminpgc.baslikname,yaseminpgc.baslikorders,
                yaseminpgc.basliklactions};
        for (int i = 0; i <baslik.length ; i++) {
            Assert.assertTrue(baslik[i].isDisplayed());

        }
    Driver.closeDriver();
    }
}
