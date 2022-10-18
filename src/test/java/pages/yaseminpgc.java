package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class yaseminpgc {
    public yaseminpgc() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

  @FindBy(xpath = "(//*[text()='Sign In'])[1]")
    public WebElement ilkSign_inButonu;
//otomassyon


}
