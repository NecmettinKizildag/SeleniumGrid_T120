package tests;

import org.testng.annotations.*;

import static manage.DriverManage.*;

public class Grid_02 {

    @BeforeTest
    @Parameters("browser")
    void beforeTest(@Optional("grid_chrome") String browser){
        setDriver(browser);
    }

    @Test
    void test01(){

        driver.get("https://www.google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    @AfterTest
    void afterTest(){
        closeDriver();
    }
}
