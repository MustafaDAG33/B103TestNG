package techproed.tests.listeners;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

import java.util.NoSuchElementException;

@Listeners(techproed.utilities.Listeners.class)
public class ListenersTest1  {

    //1.listeners paketi olustur
    //2. ListenersTest1 classi olustur
    //3. 4 tane metot olustur: test1(PASS), test2(FAIL), test3(SKIP), test4(NOSUCHELEMETNEXCEPTION)
    //4. Test classi Listeners class ile iliskilendir : @Listeners(utilities.Listeners.class)


    @Test
    public void test1() {
        System.out.println("PASS");
        Assert.assertTrue(true);
    }

    @Test
    public void test2() {
        System.out.println("FAIL");
        Assert.assertTrue(false);
    }

    @Test
    public void test3() {
        System.out.println("SKIP");
        throw new SkipException("Metodu Atla");
    }

    @Test
    public void test4() {
        System.out.println("Exception");
        Driver.getDriver().get("https://www.techproeducation.com");
        Driver.getDriver().findElement(By.xpath("asdgadfhadfgnh"));

    }


}
