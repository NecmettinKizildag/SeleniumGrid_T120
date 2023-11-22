package tests;

import manage.DriverManage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.lang.annotation.Target;
import java.net.MalformedURLException;
import java.net.URL;

public class Grid_01 {
    DriverManage driverManage = new DriverManage();

    static WebDriver driver;

    public static void main(String[] args) throws MalformedURLException {

        driver = new RemoteWebDriver(new URL("http://192.168.0.68:4444"),new EdgeOptions());

        driver.get("https://www.google.com");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.close();

    }

    @Test
    void fireFoxTest() throws MalformedURLException {

        driver = new RemoteWebDriver(new URL("http://192.168.0.68:4444"), new FirefoxOptions());

        driver.get("https://www.wisequarter.com");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.close();
    }

    @Test
    void remoteChromeDriver(){
        driver = driverManage.setUpChromeDriver();

        driver.get("https://www.youtube.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.close();
    }


    @Test
    void remoteFireFoxDriver(){
        driver = driverManage.setUpFireFoxDriver();

        driver.get("https://www.youtube.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.close();
    }


}
