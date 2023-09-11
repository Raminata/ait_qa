package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.remindly.tests.TestBase.app;

public class MainScreenTests {

        @Test
        public void launchAppTest() {
            Assert.assertTrue(app.getMainScreenHelper()
                    .isMainScreenMessagePresent());
        }
    }

