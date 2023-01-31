package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day23_ExcelLogin {

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    ExcelUtils excelUtils;
    List<Map<String, String>> excelDatalari;

    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        //homepage logine tikla
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();

        //loginlink butonu sadece ilk giriste sayfada gorunur.
        //ikinci ucuncu girislerde sayfada gorunmeyeceginden nosuchelementexception alinir.
        //biz bu exception'u  try catch kullanarak yakalariz ve test case calismaya devam eder.

        try {
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);// 1 saniye bekle
        }catch (Exception e){
        }

        //sonraki girisler
        try{
//            kullanici ID ye tikla      --->>> try catch
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
//            Logout linkine tikla       --->>> try catch
            blueRentalHomePage.logOutLink.click();
            ReusableMethods.waitFor(1);
//            OK e tikla                --->>> try catch
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
//            home page logine tikla    --->>> try catch
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }

    }

    @Test
    public void customerLogin() throws IOException {
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";//-->./ onceki tum dosyalari icer.
        String sayfa = "customer_info";
        //datalari excel utils metotlarini kullanarak buraya alacagiz
        excelUtils = new ExcelUtils(path,sayfa);
        //excel datalarini getDataList methoduyla cekelim
        excelDatalari = excelUtils.getDataList();

        //loop kullanarak datalari tek tek test casede kullan
        for(Map<String,String> data: excelDatalari){
            login();//her loop'ta login sayfasina goturecek
            //kullanici adini
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.emailBox.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);
            //kullanici sifresini
            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));
            ReusableMethods.waitFor(1);
            //login tikla
            blueRentalLoginPage.loginButton.click();
            ReusableMethods.waitFor(1);
            ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);
            ReusableMethods.waitFor(1);
            //her bir giristen sonra ekran goruntusu aldik
            ReusableMethods.getScreenshot("EkranGoruntusu");
        }

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }



    /*
sam.walker@bluerentalcars.com   c!fas_art
kate.brown@bluerentalcars.com   tad1$Fas
raj.khan@bluerentalcars.com v7Hg_va^
pam.raymond@bluerentalcars.com  Nga^g6!
------ILK GIRIS---------
HOME PAGE DEYIZ
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
------2. GIRIS-----
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
------3. GIRIS---------
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
---------4. GIRIS------------
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
 */


}
