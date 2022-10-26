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

public class TC_002 {
    public TC_002() throws IOException {
    }
yaseminpgc yaseminpgc=new yaseminpgc();

    //Müşterilerin bilgileri print olabilmeli,pdf,excel,csv şeklinde indirilebilmeli
    /*
    1-vendor https://hubcomfy.com/ adersine gider
2-Giriş simgesine tıklar
3-Açılan pncereden sign_in simgesine tıklar
4-Username alanına valid bir username girer
5-Password alanına valid bir password girer
6-Sign in butonuna tıklar

7-sign out sekmesini tıklar
8-My Account sekmesine tıklar ve customer menüse erişir
9-Müşteri bilgilerini print yapar,pdf,excel,csv şeklinde indirir


     */
   yaseminmethod yaseminmethod=new yaseminmethod();

    @Test
    public void test02() throws InterruptedException, IOException {
        yaseminmethod.ilk();

      Actions actions=new Actions(Driver.getDriver());
        // 8-Store manager sekmesine tıklar ve customer menüse erişir
        yaseminpgc.storemanagermenu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        Assert.assertTrue( yaseminpgc.customersMenu.isDisplayed());
        yaseminpgc.customersMenu.click();
        //9-Müşteri bilgilerini print yapar,pdf,excel,csv şeklinde indirir
        WebElement download[]={yaseminpgc.pdf,yaseminpgc.excel,yaseminpgc.csv,yaseminpgc.print};
        for (int i = 0; i <download.length ; i++) {
            Assert.assertTrue(download[i].isEnabled());
        }
 Driver.closeDriver();
    }
}
