package com.revathi.adminuat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by revathi on 12/16/2014.
 */
public class BaseTest extends BaseClass {

    @BeforeClass
    public static void startBrowser(){
        driver= new FirefoxDriver();
        driver.get("http://insoftt.trial47.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

   @AfterClass
    public static void stopBrowser()
    {
        driver.quit();
    }

}
