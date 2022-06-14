package utilities.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossDriver {

    private CrossDriver(){

    }

    static WebDriver driver;

    public static WebDriver getDriver(String browser){

        browser = browser == null ? ConfigReader.getProperty("browser") : browser;

        if (driver==null) {
            switch (browser){

                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();

                    //case "safari" :
                    //  WebDriverManager.safaridriver().setup();
                    //    driver=new SafariDriver(); safariyi artik desteklemioorr
                    //  break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;

                case"headless-chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }


        }
        return driver;
    }
    public static void closeDriver(){

        if (driver!=null) { // driver'a deger atanmissa

            driver.close();

            driver=null;
        }
    }
}
