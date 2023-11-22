package manage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManage {

    public static WebDriver driver;

    DesiredCapabilities capabilities = new DesiredCapabilities();

    public WebDriver setUpChromeDriver(){

        capabilities.setPlatform(Platform.ANY);
        capabilities.setBrowserName(ConfigReader.getProperty("chromeBrowser"));
        capabilities.setVersion(ConfigReader.getProperty("chromeVersion"));

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(capabilities);

        try {
            driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("url")),chromeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        System.out.println("****** SetUp Chrome Driver ******");


        return  driver;
    }


    public WebDriver setUpFireFoxDriver(){

        capabilities.setPlatform(Platform.ANY);
        capabilities.setBrowserName(ConfigReader.getProperty("firefoxBrowser"));
        capabilities.setVersion(ConfigReader.getProperty("firefoxVersion"));

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.merge(capabilities);

        try {
            driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("url")),firefoxOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        System.out.println("****** SetUp FireFox Driver ******");


        return  driver;
    }

    public static void setDriver(String browser){
        switch (browser){
            case "grid_chrome":{
                ChromeOptions chromeOptions = new ChromeOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("url")),chromeOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("***** Selenium Grid Chrome *****");
                break;
            }
            case "grid_firefox":{
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("url")),firefoxOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("***** Firefox  WebDriver *****");
                break;
            }
            case "grid_IE":{
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("url")),internetExplorerOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("***** IE WebDriver *****");
                break;
            }
            case "grid_edge":{
                EdgeOptions edgeOptions = new EdgeOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("url")),edgeOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("***** Edge WebDriver *****");
                break;
            }
            default:{
                WebDriverManager.chromedriver().setup();
                System.out.println("***** Chrome WebDriver *****");
                driver = new ChromeDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    public static void closeDriver(){
        if (driver!=null){
            driver.close();
        }
    }
}
