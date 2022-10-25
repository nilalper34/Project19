package tests.US_06;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Saadetpgc;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.SaadetMethods;

import java.io.IOException;

public class US006_TC006 {

    @Test
    public void test06() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  10-Categories den Books&Music&Film seceneginin var oldugunu test eder
        Assert.assertEquals(page.booksMusicFilmText.getText(),"Books & Music & Film","Books& Music&Film secenegi gorunmuyor...");

        //  11-Books& Music&Film ı tiklar
        page.booksMusicFilmBox.click();

        //  12-Books& Music&Film ın tıklandigini test eder
        Assert.assertTrue(page.booksMusicFilmBox.isSelected(),"Books& Music&Film box tiklanamiyor...");

        ReusableMethods.getScreenshotWebElement("Books& Music&Film box",page.booksMusicFilmText);


        Driver.getDriver().close();
    }
}
