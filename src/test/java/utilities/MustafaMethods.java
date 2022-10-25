package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import pages.MustafaPgc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MustafaMethods {

    public static List<Double> actualLowList;
    public static List<Double> expectedLowlist;

    public static List<Double> actualHighList;

    public static List<Double> expectedHighList;


    public static void getEmailCode() {     // Gecici email sitesinden mail adresini ve verification kodunu alan method

        MustafaPgc mustafaPgc = new MustafaPgc();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get("https://www.mohmal.com/tr/inbox");

        List<String> windowList = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowList.get(1));


        mustafaPgc.verificationEmail.getText();
        System.out.println("Verification Email = " + mustafaPgc.verificationEmail.getText());

        String verificationMailText= mustafaPgc.verificationEmail.getText();

        Driver.getDriver().switchTo().window(windowList.get(0));
        ReusableMethods.waitFor(2);
        mustafaPgc.emailKutusu.sendKeys(verificationMailText);

        mustafaPgc.verificationCodeKutusu.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().window(windowList.get(1));
        ReusableMethods.waitFor(3);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);
        //ReusableMethods.jsScrollClick(mustafaPgc.tempMailBox);
        mustafaPgc.tempMailBox.click();

        WebElement iframe = Driver.getDriver().findElement(By.cssSelector("div>#read>div>iframe"));

        Driver.getDriver().switchTo().frame(iframe);
        ReusableMethods.waitForVisibility(mustafaPgc.tempVCodeText,15);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        String verificationTextYazisi = mustafaPgc.tempVCodeText.getText();
        System.out.println("verificationTextYazisi = " + verificationTextYazisi);

        int vCode = Integer.parseInt(mustafaPgc.tempVCodeText.getText().replaceAll("\\D",""));

        String vcode2 = String.valueOf(vCode);

        Driver.getDriver().switchTo().defaultContent();

        Driver.getDriver().switchTo().window(windowList.get(0));
        ReusableMethods.waitFor(2);

        //  5- Email adresine gelen Verification Code ilgili kutuya girer
        mustafaPgc.verificationCodeKutusu.sendKeys(vcode2);

    }
    public static void registeredGetEmailCode() {   // Daha once register olmus mail adresine login olup oradaki verification kodunu alan method

        MustafaPgc mustafaPgc = new MustafaPgc();
        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get("https://login.yahoo.com/");

        List<String> windowList = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowList.get(1));
        mustafaPgc.yahooUsernameBox.sendKeys("proje1981");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        mustafaPgc.yahooPasswordBox.sendKeys("Proje8119");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(3);
        actions.moveToElement(mustafaPgc.yahooMailSimge).perform();
        ReusableMethods.waitFor(3);
        actions.moveToElement(mustafaPgc.yahooSonGelenMail).click().perform();
        ReusableMethods.waitFor(2);
        String yahooCodeStr = mustafaPgc.yahooCode.getText();
        System.out.println("yahooCodeStr = " + yahooCodeStr);

        Driver.getDriver().switchTo().window(windowList.get(0));

        mustafaPgc.verificationCodeKutusu.sendKeys(yahooCodeStr);

    }
    public static void priceFromLowToHigh() {       // Web sitesinden fiyatlari cekip dusukten buyuge siralayan method

        MustafaPgc mustafaPgc = new MustafaPgc();

        // Asagıdaki islem ile fiyati dusukten yuksege olan urunlerin fiyatları String bir list'e atılmıstır
        List<String> list = new ArrayList<>();
        for (WebElement w : mustafaPgc.urunFiyatLowToHighListWE) {
            list.add(w.getText());
        }
        System.out.println(list);

        System.out.println("list.size() = " + list.size());

        // Asagıdaki islem ile String List teki elemanların icinden rakam dısındaki kararterler cıkarılmıstır
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i).replace("$",""));
            list.set(i,list.get(i).replace(",",""));
        }
        System.out.println("Rakamlardan olusan String List = " + list);
        //Asagıdaki işlem ile list'in elemanlarında indirimden onceki fiyatlar cıkarılmıstır.
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(" ")) {
                list.set(i,list.get(i).substring(0,list.get(i).indexOf(" ")));
            }
        }
        System.out.println("list eski fiyatlardan arindirilmis = " + list);

        actualLowList = new ArrayList<>();
        for (String w:list) {
            actualLowList.add(Double.valueOf(w));
        }

        System.out.println("Strig den cevrilmis listDouble = " + actualLowList);

        // Asagıda, bu doublelist yeni bir arraylist olarak listDoubleexpected isimli yeni bir liste atanmıs,
        // Collections.sort komutu ile bu listenin elemanlari kucukten buyuge siralanmis
        // Assert ise de 2 liste karsilastirilmistir.

        expectedLowlist = new ArrayList<>();
        for (Double w: actualLowList) {
            expectedLowlist.add(w);
        }
        Collections.sort(expectedLowlist);
        System.out.println("listDoubleExpected = " + expectedLowlist);

    }

    public static void priceFromHighToLow () {          // Web sitesinden fiyatlari cekip buyukten kucuge siralayan method
        MustafaPgc mustafaPgc = new MustafaPgc();

        // Asagıdaki islem ile fiyati dusukten yuksege olan urunlerin fiyatları String bir list'e atılmıstır
        List<String> list = new ArrayList<>();
        for (WebElement w : mustafaPgc.urunFiyatHighToLowListWE) {
            list.add(w.getText());
        }
        System.out.println(list);
        //    System.out.println(list.get(0));
        System.out.println("list.size() = " + list.size());

        // Asagıdaki islem ile String List teki elemanların icinden rakam dısındaki kararterler cıkarılmıstır
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i).replace("$",""));
            list.set(i,list.get(i).replace(",",""));
        }
        System.out.println("Rakamlardan olusan String List = " + list);
        //Asagıdaki işlem ile list'in elemanlarında indirimden onceki fiyatlar cıkarılmıstır.
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(" ")) {
                list.set(i,list.get(i).substring(0,list.get(i).indexOf(" ")));
            }
        }
        System.out.println("list eski fiyatlardan arindirilmis = " + list);

        actualHighList = new ArrayList<>();
        for (String w:list) {
            actualHighList.add(Double.valueOf(w));
        }

        System.out.println("Strig den cevrilmis actualHighList = " + actualHighList);

        // Asagıda bu doublelist yeni bir arraylist olarak listDoubleexpected isimli yeni bir liste atanmıs,
        // Collections.sort komutu ile bu listenin elemanlari buyukten kucuge siralanmis
        // Assert ile de 2 liste eşit mi diye karsilastirilmistir.

        expectedHighList = new ArrayList<>();
        for (Double w:actualHighList) {
            expectedHighList.add(w);
        }

        Collections.sort(expectedHighList);
        Collections.reverse(expectedHighList);
        System.out.println("expectedHighList = " + expectedHighList);
    }
}
