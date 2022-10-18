package tests.Us_0012;

import org.testng.annotations.Test;
import pages.yaseminpgc;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_001 {
yaseminpgc yaseminpgc=new yaseminpgc();

@Test
public  void test01(){
    Driver.getDriver().get(ConfigReader.getProperty("HubcomfyUrl"));

    yaseminpgc.ilkSign_inButonu.click();
    Driver.closeDriver();

}

}
