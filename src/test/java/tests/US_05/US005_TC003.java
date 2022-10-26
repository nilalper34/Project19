package tests.US_05;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Saadetpgc;
import utilities.Driver;
import utilities.SaadetMethods;

public class US005_TC003 {


    @Test
    public void test003() throws InterruptedException {

        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());

        //  9-"Add New" e tiklar
        page.addNewButton.click();

        //  10-"Product Title" seceneginin oldugunu test eder
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(page.productTitle.isDisplayed());

        //  11-"Sale Price ($)" secenegi oldugunu test eder
        System.out.println(page.salePrice.getText());
        Assert.assertEquals(page.salePrice.getText() ,"Sale Price ($)");


        Driver.getDriver().close();
    }
}
