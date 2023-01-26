package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "exampleInputEmail1")
    public WebElement userName;

    @FindBy(id = "exampleInputPassword1")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible fade show']")
    public WebElement logged;

    @FindBy(xpath = "//*[@class='fa fa-sign-out-alt']")
    public WebElement logout;


}
