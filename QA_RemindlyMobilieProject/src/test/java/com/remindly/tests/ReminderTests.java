package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReminderTests extends TestBase {

    @Test
    public void addReminderPositiveTest() {
        //tap on add reminder
        app.getMainScreenHelper()
                .tabOnAddReminder();
        //enter title
        app.getReminder()
                .enterTitle("Holiday");
        //tab on date field
        app.getReminder()
                .tapOnDateField();
        //swipe to month
        app.getReminder()
                .swipeToMonth("future", "SEP", 2);
        //select date
        app.getReminder()
                .selectDate(0);
        //tab on year
        app.getReminder()
                .tapOnYear();
        //swipe to year
        app.getReminder()
                .swipeToYear("future", "2024");
        //tap on "ok"
        app.getReminder()
                .tapOnOk();
        //tap on time field
        app.getReminder()
                .tapOnTimeField();
        //select time
        app.getReminder()
                .selectTime("pm", 542, 1191,
                        542, 653);
        //tap on "ok"
        app.getReminder().tapOnOk();
        //tap on repetition interval
        app.getReminder()
                .tapOnRepetitionInterval();
        //define
        app.getReminder()
                .defineRepetition("2");

        //swipe up
        app.getReminder()
                .swipe(0.7, 0.4);
        //tap on type of repetition
        app.getReminder()
                .tapOnTypeOfRepetition();

        //select type of repetition
        app.getReminder()
                .selectTypeOfRepetition("Week");

        //save reminder
        app.getReminder()
                .saveReminder();

        //assert by title
        Assert.assertTrue(app
                .getMainScreenHelper()
                .isReminderTitlePresent()
                .contains("Holiday"));
    }
}
