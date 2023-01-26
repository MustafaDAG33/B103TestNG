package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {

    //page objelerini bu sinifta buluruz.
    //1.constructor; her page sinifi constructor ile baslar
    public OpenSourcePage(){
        //pageFactory seleniumdan gelen ve bu sayfa elementlerini intantiate etmek icin kullanilir.
        //sayafa objeleri cagirildiginda null pointer alinmaz.
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //page objelerini olustur
    //public Webelement username = Driver.getDriver().findElement(By.name("username"));
    @FindBy(name = "username")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;








}
