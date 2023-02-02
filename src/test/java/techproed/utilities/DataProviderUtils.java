package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider
    public Object[][] musteriVerileri(){
        Object[][] musteriGirisBilgileri= {
                {"manager1","12345"},
                {"manager2","98765"},
                {"manager3", "5678"}

        };
        return musteriGirisBilgileri;

    }

    @DataProvider
    public Object[][] musteriHizmetleriVerileri(){
        Object[][] musteriHizmetleriGirisBilgileri= {
                {"adam1","3456"},
                {"ali2","1234"},
                {"nancy3", "7890"}

        };
        return musteriHizmetleriGirisBilgileri;

    }

    @DataProvider
    public Object[][] personelVerileri(){
        Object[][] personelGirisBilgileri= {
                {"rukiye1","abc1"},
                {"mehmet2","123r"},
                {"emin3", "3edc"},
                {"baran4", "4try"},
                {"okumus5", "5olk"}

        };
        return personelGirisBilgileri;

    }

    //excelden dataprovider'a data gelir
    @DataProvider
    public Object[][] customerData(){
        //dataProviderTest2 ile farki bu metotta datalar excelden gelir.
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);

        Object[][] musteriBilgileri = excelUtils.getDataArrayWithoutFirstRow();
        return musteriBilgileri;
    }





}
