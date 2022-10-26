package tests.US_19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.yaseminpgc;
import utilities.Driver;
import utilities.yaseminmethod;

import java.io.IOException;

public class Tc_001 {
    public Tc_001() throws IOException {
    }

    yaseminpgc yaseminpgc = new yaseminpgc();

    //Store manager olarak takipçileri görebilmeliyim
    /*
     1-vendor https://hubcomfy.com/ adersine gider
     2-Giriş simgesine tıklar
     3-Açılan pncereden sign_in simgesine tıklar
    4-Username alanına valid bir username girer
    5-Password alanına valid bir password girer
    6-Sign in butonuna tıklar
    7-sign out sekmesini tıklar
    8-store manger sekmesinde "Followings" secenegini görür ve erişir
    9-"Followings" sekmesinde takipçilerin listesini görür ve takipçilere ait isim,eposta,yaptıkları işlemleri tanımlar
*/
    yaseminmethod yaseminmethod=new yaseminmethod();
    @Test
    public void test01() throws InterruptedException, IOException {
        yaseminmethod.ilk();
      Actions actions=new Actions(Driver.getDriver());
        // 7-Store manager sekmesine tıklar ve customer menüse erişir
        yaseminpgc.storemanagermenu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        Assert.assertTrue(yaseminpgc.followersMenu.isDisplayed());
        yaseminpgc.followersMenu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(yaseminpgc.emptyfollowers.isDisplayed());
        Driver.closeDriver();
    }
}