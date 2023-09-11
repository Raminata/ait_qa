package com.remindly.tests;


import com.remindly.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase extends ApplicationManager {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        app.init();
    }

    @AfterMethod
    public void quite() {
        app.stop();
    }
}


/**
 * from Appium
 * {
 * "platformName": "Android",
 * "platformVersion": "8.0",
 * "deviceName": "mob",
 * "appPackage": "com.blanyal.remindly",
 * "appActivity": "com.blanyal.remindme.MainActivity"
 * }
 */
