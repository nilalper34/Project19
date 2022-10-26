package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Saadetpgc;

public class SaadetMethods {

    static Saadetpgc page;

    public static void products() throws InterruptedException {

        page= new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        //  1-Store Manager  "https://hubcomfy.com/"  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));

        //  2-Store Manager sign in butonuna tiklar
        page.signin.click();

        //  3-Store Manager gecerli bir username girer
        page.username.sendKeys(ConfigReader.getProperty("s_username"));

        //  4- Store Manager gecerli bir password girer
        page.password.sendKeys(ConfigReader.getProperty("s_password"));

        //  5-Store Manager sign in butonuna tiklar
        page.signinButton.click();

        //  6-Store Manager "My Account" a tiklar
        Thread.sleep(2000);
        jse.executeScript("arguments[0].scrollIntoView(true);", page.myAccount);
        jse.executeScript("arguments[0].click();" , page.myAccount);

        //  7-Store Manager "Store Manager" a tiklar
        Thread.sleep(2000);
        page.storeManager.click();

        //  8-Store Manager "Products" a tiklar
        page.products.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }

}
