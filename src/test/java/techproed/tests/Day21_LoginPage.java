package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_LoginPage {

    //https://testcenter.techproeducation.com/index.php?page=form-authentication
    //Page object Model kullanarak sayfaya giriş yapildigini test edin

    @Test
    public void loginPageTest(){

        Driver.getDriver().get(ConfigReader.getProperty("login_page_url"));
        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));

        loginPage.submit.click();
        Assert.assertTrue(loginPage.logged.isDisplayed());
        loginPage.logout.click();

        Driver.closeDriver();



    }




}
