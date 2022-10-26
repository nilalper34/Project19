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

public class US006_TC001 {

    @Test
    public void test001() throws InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //10-Categories den Besin takviyeleri seceneginin var oldugunu test eder
        Assert.assertEquals(page.besinTakviyeleriText.getText() , "Besin takviyeleri","Besin takviyeleri goronmuyor...");

        //11-Besin takviyelerine tiklar
        page.besinTakviyeleriBox.click();

        //12-Besin takviyelerine tıklandigini test eder
        Assert.assertTrue(page.besinTakviyeleriBox.isSelected(),"Besin takviyeleri tiklanamadi...");

        try {
            ReusableMethods.getScreenshotWebElement("Besin takviyeleri box",page.besinTakviyeleriText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Driver.getDriver().close();

    }
}
