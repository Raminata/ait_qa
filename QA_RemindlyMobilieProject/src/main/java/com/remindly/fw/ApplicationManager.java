package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    AppiumDriver driver;
    DesiredCapabilities capabilities;
    MainScreenHelper mainScreenHelper;

    ReminderHelper reminder;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        init();
    }


    public ReminderHelper getReminder() {
        return reminder;
    }

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities(); //capabilities is - settings

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("deviceName", "mob");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.blanyal.remindly");
        capabilities.setCapability("appActivity", "com.blanyal.remindme.MainActivity");
        capabilities.setCapability("app", "C:/Tools/remindly.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage()
                .timeouts()
                .implicitlyWait(20, TimeUnit.SECONDS);


        mainScreenHelper = new MainScreenHelper(driver);

        reminder = new ReminderHelper(driver);

        }


    public MainScreenHelper getMainScreenHelper() {
        return mainScreenHelper;
    }


    public void stop() {
        driver.quit();
    }



}
