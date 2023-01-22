package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day20_Driver_ConfigTest {


    @Test
    public void test1() {
        //amazona git
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        //title'in amazon icerdigini test et
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));

    }

}
