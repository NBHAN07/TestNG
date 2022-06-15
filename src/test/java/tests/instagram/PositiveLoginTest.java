package tests.instagram;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.devtools.v97.input.model.DragDataItem;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InstagramPage;
import utilities.utilities.ConfigReader;
import utilities.utilities.Driver;
import utilities.utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PositiveLoginTest extends TestBaseRapor {


    @Test
    public void positiveLoginTest() throws InterruptedException {

        extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve sifre ile giris yapabilmeli" );
        InstagramPage instaPage =new InstagramPage();


      //instagram ana sayfaya  gidiniz

        Driver.getDriver().get(ConfigReader.getProperty("instagramUrl"));
        extentTest.info("instagram sayfasina gidildi");


      //dogru kullanici adi ve sifre gir

        instaPage.userNameBox.sendKeys(ConfigReader.getProperty("instagramValidEmail"));
        extentTest.info("e mail basarili sekilde girildi");
        instaPage.passwordBox.sendKeys(ConfigReader.getProperty("instagramValidPassword"));
        extentTest.info("password basarili sekilde girildi");

        //giris yap butonu tiklanabilir olunca tikla
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(instaPage.girisYapBox));
        instaPage.girisYapBox.click();
        extentTest.info("giris yap butonu gorunur oldugunda tiklandi");

        //save your login info yazisinda "simdi degil" e tikla
        instaPage.simdiDegil1.click();
        extentTest.info("ilk sekme simdi degil diyerek kapatildi");

        //"turn on notifications" yazisinda "simdi degil" e tikla
        instaPage.simdiDegil2.click();
        extentTest.info("ikinci sekme simdi degil diyerek kapatildi");

        //giris yapildigini fotografli sekilde dogrula ve rapor et

        instaPage.homePageProfilElement.sendKeys(Keys.ENTER);
        extentTest.info("profil dropdowna tiklandi");


        wait.until(ExpectedConditions.visibilityOf(instaPage.profilElementi));

        instaPage.profilElementi.click();
        extentTest.info("profil sekmesine tiklandi");

        Thread.sleep(3000);

        String date= LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"));
        File tumSayfa=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tumSayfa,new File("target/instagram/tumSayfa"+date+".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.info("ekran goruntusu alindi");


        Assert.assertTrue(instaPage.profilFotografi.isDisplayed());

        extentTest.pass("kullanici basarili sekilde giris yapti");

        //sayfayi kapat
















    }







}
