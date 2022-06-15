package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.utilities.Driver;

public class InstagramPage {

    public InstagramPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userNameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[text()='Giriş Yap']")
    public WebElement girisYapBox;


    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement simdiDegil1;

    @FindBy(xpath = "//*[text()='Şimdi Değil']")
    public WebElement simdiDegil2;

    @FindBy(xpath = "//div[@class='_aaw9']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//span[@class='_aa8h _aa8i']")
    public WebElement homePageProfilElement;

    @FindBy(xpath = "(//div[@class='_ab8w  _ab94 _ab99 _ab9h _ab9m _ab9p'])[1]")
    public WebElement profilElementi;


    @FindBy(xpath = "//img[@class='_aadp']")
    public WebElement profilFotografi;








}
