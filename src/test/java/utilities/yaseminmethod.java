package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.yaseminpgc;

import java.io.IOException;

public class yaseminmethod {

    public void ilk() throws IOException, InterruptedException {
        yaseminpgc yaseminpgc=new yaseminpgc();
        //  1-vendor https://hubcomfy.com/ adersine gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));

        //  2-Giriş simgesine tıklar
        yaseminpgc.ilkSign_inButonu.click();

        //3-Username alanına valid bir username girer
        yaseminpgc.usurname.sendKeys(ConfigReader.getProperty("hbcValidUsurnamey"));

        // 4-Password alanına valid bir password girer
        yaseminpgc.password.sendKeys(ConfigReader.getProperty("hbcValidPasswordy"));

        // 5-Sign in butonuna tıklar
        yaseminpgc.ikinciSign_inButonu.click();


        // 6-vendor olarak basarılı giriş yaptıgını dogrular
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(7000);
        //  7-sign out sekmesini tıklar
        yaseminpgc.sign_inOutButonu.click();

    }
}
