package tests.US_16;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.yaseminpgc;
import utilities.Driver;
import utilities.yaseminmethod;

import java.io.IOException;

public class TC_003 {
    public TC_003() throws IOException {
    }

    yaseminpgc yaseminpgc = new yaseminpgc();
    /*
    "Add New" seceneği tıklanabilir olmalı
    add new diyerek yeni müşteri eklenebilmeli ve bu müşterilere ait kullanıcı adı,email,isim,soyisim girilebilmeli
     */
/*
1-vendor https://hubcomfy.com/ adersine gider
2-Giriş simgesine tıklar
3-Username alanına valid bir username girer
4-Password alanına valid bir password girer
5-Sign in butonuna tıklar
6-sign out sekmesini tıklar
7- store manager secenegineginden  "Customers" sekmesini görür ve erişir
8-"Add New" seceneginin tıklanır oldugunu görür ve buraya tıklayarak yeni müşteri ekleyebilir,
bu müşterilere ait kullanıcı adı,email,isim,soyisim girebilir
*/
yaseminmethod yaseminmethod=new yaseminmethod();
    @Test
    public void test02() throws InterruptedException, IOException {
        yaseminmethod.ilk();
       Actions actions=new Actions(Driver.getDriver());
        // 7-Store manager sekmesine tıklar ve customer menüse erişir
        yaseminpgc.storemanagermenu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        Assert.assertTrue(yaseminpgc.customersMenu.isDisplayed());
        yaseminpgc.customersMenu.click();
       //8-"Add New" seceneginin tıklanır oldugunu görür ve buraya tıklayarak yeni müşteri ekleyebilir,
        // bu müşterilere ait kullanıcı adı,email,isim,soyisim girebilir
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        yaseminpgc.addnewbutonu.click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        Faker faker=new Faker();

        yaseminpgc.addusurname.sendKeys(faker.name().username());
           actions.sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.TAB).sendKeys("Java")
                .sendKeys(Keys.TAB).sendKeys("Kava")
                .sendKeys(Keys.TAB).sendKeys("Kava Ltd. Sti.")
                .sendKeys(Keys.TAB).sendKeys("+902321112233")
                .sendKeys(Keys.TAB).sendKeys("Erdem Mahallesi 672 Sokak")
                .sendKeys(Keys.TAB).sendKeys("Elif Apt. No:75 D:6")
                .sendKeys(Keys.TAB).sendKeys("Turkey")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Konak").perform();
        Thread.sleep(1000);
        Select select=new Select(yaseminpgc.stateddm);
        select.selectByIndex(34);

        actions.sendKeys(Keys.TAB).sendKeys("34145").sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
      yaseminpgc.submit.click();


    }
}