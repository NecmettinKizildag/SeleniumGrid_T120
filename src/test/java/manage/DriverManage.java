package manage;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManage {

    static WebDriver driver;

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
}
