package tests.US_05;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Saadetpgc;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.SaadetMethods;

import java.io.IOException;

public class US005_TC002 {

    @Test
    public void test02() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();

        //  10-Urun icin "Virtual" seceneginin oldugunu test eder
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        System.out.println(page.virtualText.getText());
        Assert.assertEquals(page.virtualText.getText(),"Virtual");

        //  11-Urun icin "Downloadable" seceneginin oldugunu test eder
        System.out.println(page.downloadableText.getText());
        Assert.assertEquals(page.downloadableText.getText() ,"Downloadable");

       ReusableMethods.getScreenshot("Add New Page");

        Driver.getDriver().close();


    }
}
