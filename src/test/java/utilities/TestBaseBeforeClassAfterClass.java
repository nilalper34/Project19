package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class TestBaseBeforeClassAfterClass {

    // Abstract yapmamizin sebebi, bu class'tan obje uretilmesinin onune gecmektir.

    protected WebDriver driver;    //public de olabilir.
    //@BeforeClass ve  @AfterClass notasyonlarini kullanirken JUnit'deki gibi static yapmaya gerek yok.
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
