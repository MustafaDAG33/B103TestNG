package techproed.tests.dataprovider;

import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;

public class Day25_DataProviderTest4 {

    //bu ornekte data provider methodumuz util class'dan gelecek.


    @Test(dataProvider = "musteriVerileri",dataProviderClass = DataProviderUtils.class)
    public void musteriVerileriTest(String username, String password) {
        System.out.println("Username : "+username+". Password : "+password);

    }

    @Test(dataProvider = "musteriHizmetleriVerileri", dataProviderClass = DataProviderUtils.class)
    public void musteriHizmetleriVerileri(String username, String password){
        System.out.println(username+" | "+password);
    }

    @Test(dataProvider = "personelVerileri", dataProviderClass = DataProviderUtils.class)
    public void personelVerileriTest(String username, String password) {
        System.out.println(username+" | "+password);
    }

    @Test(dataProvider = "customerData",dataProviderClass = DataProviderUtils.class)
    public void customerDataTest(String username,String password) {
        System.out.println(username+" || "+password);
    }






}
