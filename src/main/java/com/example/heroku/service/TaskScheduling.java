package com.example.heroku.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class TaskScheduling {

    @Autowired
    private SchedulerDataService schedulerDataService;


    @Scheduled(cron="0 0 12 * * *",zone = "IST")
    public void runEveryDayAt12PM() throws IOException {
        String EVERY_DAY_12PM_IST = "Every Day At 12.00 PM IST";
        schedulerDataService.saveSchedulerDetails(EVERY_DAY_12PM_IST);
    }

    // Every end of the month at 5.00 PM
    @Scheduled(cron = "0 0 17 L * *",zone = "IST")
    public void runEveryEndOfTheMonth() throws IOException {
        String EVERY_END_OF_THE_MONT_AT_5PM_IST = "Every End Of The Month At 5.00 PM IST ";
        schedulerDataService.saveSchedulerDetails(EVERY_END_OF_THE_MONT_AT_5PM_IST);

    }

    @Scheduled(cron = "0 0 0 1 JAN *",zone = "IST")
    public void runAtEvery1stJanuary() throws IOException {
        String EVERY_1ST_JANUARY_IST = "Every 1st Of January At 12.00 AM IST";
        schedulerDataService.saveSchedulerDetails(EVERY_1ST_JANUARY_IST);

    }

    @Scheduled(cron = "0 0 0 1 JUL *",zone = "IST")
    public void runAtEvery1stJuly() throws IOException {
        String EVERY_1ST_JULY_IST = "Every 1st Of July At 12.00 AM IST";
        schedulerDataService.saveSchedulerDetails(EVERY_1ST_JULY_IST);

    }

    @Scheduled(cron = "0 0 0 1 JAN * ",zone = "IST")
    public void runEveryEndOfTheYear() throws IOException {
        String EVERY_END_OF_THE_YEAR_IST = "Every End Of The Year At 12.00 AM IST";
        schedulerDataService.saveSchedulerDetails(EVERY_END_OF_THE_YEAR_IST);

    }

    //0 0 0 ? * SUN *
    @Scheduled(cron = "0 0 0 ? * SUN",zone = "IST")
    public void runEveryWeekendAtSunday() throws IOException {
        String EVERY_SUNDAY_OF_THE_MONTH_IST = "Every Sunday Of The Month At 12.00 AM IST";
        schedulerDataService.saveSchedulerDetails(EVERY_SUNDAY_OF_THE_MONTH_IST);

    }



    //0 0 0 ? * SUN *
    @Scheduled(cron = "0 0 12 ? * SUN")
    public void runEveryWeekendAtSundayDefaultZone() throws IOException {
        String EVERY_SUNDAY_OF_THE_MONTH = "Every Sunday Of The Month At 12.00 AM";
        schedulerDataService.saveSchedulerDetails(EVERY_SUNDAY_OF_THE_MONTH);

    }


    @Scheduled(cron="0 0 12 * * *")
    public void runEveryDayAt12PMDefaultZone() throws IOException {
        String EVERY_DAY_12PM = "Every Day At 12.00 PM";
        schedulerDataService.saveSchedulerDetails(EVERY_DAY_12PM);

    }

    // Every end of the month at 5.00 PM
    @Scheduled(cron = "0 0 17 L * *")
    public void runEveryEndOfTheMonthDefaultZone() throws IOException {
        String EVERY_END_OF_THE_MONT_AT_5PM = "Every End Of The Month At 5.00 PM";
        schedulerDataService.saveSchedulerDetails(EVERY_END_OF_THE_MONT_AT_5PM);

    }

    @Scheduled(cron = "0 0 0 1 JAN *")
    public void runAtEvery1stJanuaryDefaultZone() throws IOException {
        String EVERY_1ST_JANUARY = "Every 1st Of January At 12.00 AM";
        schedulerDataService.saveSchedulerDetails(EVERY_1ST_JANUARY);

    }

    @Scheduled(cron = "0 0 0 1 JUL *")
    public void runAtEvery1stJulyDefaultZone() throws IOException {
        String EVERY_1ST_JULY = "Every 1st Of July At 12.00 AM";
        schedulerDataService.saveSchedulerDetails(EVERY_1ST_JULY);

    }

    @Scheduled(cron = "0 0 0 1 JAN * ")
    public void runEveryEndOfTheYearDefaultZone() throws IOException {
        String EVERY_END_OF_THE_YEAR = "Every End Of The Year At 12.00 AM";
        schedulerDataService.saveSchedulerDetails(EVERY_END_OF_THE_YEAR);


    }






}

