package tests;

import manage.DriverManage;
import org.testng.annotations.Test;

public class Grid_03 {

    DriverManage driverManage = new DriverManage();

    @Test
    void Test(){
        driverManage.setUpChromeDriver().get("https://www.wisequarter.com");
    }

    @Test
    void Test02(){
        driverManage.setUpFireFoxDriver().get("https://www.wisequarter.com");
    }

}
