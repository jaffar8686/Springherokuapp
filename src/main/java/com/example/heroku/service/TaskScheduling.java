package com.example.heroku.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskScheduling {

    private final Logger logger = LoggerFactory.getLogger(TaskScheduling.class);

    @Autowired
    private EmailService emailService;


    @Scheduled(cron="0 0 12 * * *",zone = "IST")
    public void runEveryDayAt12PM(){

        logger.info("Running Every Day At 12:00 PM IST");
        String EVERY_DAY_12PM_IST = "Every Day At 12.00 PM IST";
        emailService.sendEmail(EVERY_DAY_12PM_IST);
    }

    // Every end of the month at 5.00 PM
    @Scheduled(cron = "0 0 17 L * *",zone = "IST")
    public void runEveryEndOfTheMonth(){
        logger.info("Running Every End Of The Month IST");
        String EVERY_END_OF_THE_MONT_AT_5PM_IST = "Every End Of The Month At 5.00 PM IST ";
        emailService.sendEmail(EVERY_END_OF_THE_MONT_AT_5PM_IST);
    }

    @Scheduled(cron = "0 0 0 1 JAN *",zone = "IST")
    public void runAtEvery1stJanuary(){
        logger.info("Running Every 1st of January IST");
        String EVERY_1ST_JANUARY_IST = "Every 1st Of January At 12.00 AM IST";
        emailService.sendEmail(EVERY_1ST_JANUARY_IST);
    }

    @Scheduled(cron = "0 0 0 1 JUL *",zone = "IST")
    public void runAtEvery1stJuly(){
        logger.info("Running Every 1st  Of July IST");
        String EVERY_1ST_JULY_IST = "Every 1st Of July At 12.00 AM IST";
        emailService.sendEmail(EVERY_1ST_JULY_IST);
    }

    @Scheduled(cron = "0 0 0 1 JAN * ",zone = "IST")
    public void runEveryEndOfTheYear(){
        logger.info("Running Every End Of The Year  IST");
        String EVERY_END_OF_THE_YEAR_IST = "Every End Of The Year At 12.00 AM IST";
        emailService.sendEmail(EVERY_END_OF_THE_YEAR_IST);

    }

    //0 0 0 ? * SUN *
    @Scheduled(cron = "0 0 0 ? * SUN",zone = "IST")
    public void runEveryWeekendAtSunday(){
        logger.info("Running Every Weekend At Sunday IST");
        String EVERY_SUNDAY_OF_THE_MONTH_IST = "Every Sunday Of The Month At 12.00 AM IST";
        emailService.sendEmail(EVERY_SUNDAY_OF_THE_MONTH_IST);
    }



    //0 0 0 ? * SUN *
    @Scheduled(cron = "0 0 12 ? * SUN")
    public void runEveryWeekendAtSundayDefaultZone(){
        logger.info("Running Every Weekend At Sunday");
        String EVERY_SUNDAY_OF_THE_MONTH = "Every Sunday Of The Month At 12.00 AM";
        emailService.sendEmail(EVERY_SUNDAY_OF_THE_MONTH);
    }


    @Scheduled(cron="0 0 12 * * *")
    public void runEveryDayAt12PMDefaultZone(){
        logger.info("Running Every Day At 12:00 PM with default zone");
        String EVERY_DAY_12PM = "Every Day At 12.00 PM";
        emailService.sendEmail(EVERY_DAY_12PM);
    }

    // Every end of the month at 5.00 PM
    @Scheduled(cron = "0 0 17 L * *")
    public void runEveryEndOfTheMonthDefaultZone(){
        logger.info("Running Every End Of The Month");
        String EVERY_END_OF_THE_MONT_AT_5PM = "Every End Of The Month At 5.00 PM";
        emailService.sendEmail(EVERY_END_OF_THE_MONT_AT_5PM);
    }

    @Scheduled(cron = "0 0 0 1 JAN *")
    public void runAtEvery1stJanuaryDefaultZone(){
        logger.info("Running Every 1st of January");
        String EVERY_1ST_JANUARY = "Every 1st Of January At 12.00 AM";
        emailService.sendEmail(EVERY_1ST_JANUARY);
    }

    @Scheduled(cron = "0 0 0 1 JUL *")
    public void runAtEvery1stJulyDefaultZone(){
        logger.info("Running Every 1st  Of July");
        String EVERY_1ST_JULY = "Every 1st Of July At 12.00 AM";
        emailService.sendEmail(EVERY_1ST_JULY);
    }

    @Scheduled(cron = "0 0 0 1 JAN * ")
    public void runEveryEndOfTheYearDefaultZone(){
        logger.info("Running Every End Of The Year");
        String EVERY_END_OF_THE_YEAR = "Every End Of The Year At 12.00 AM";
        emailService.sendEmail(EVERY_END_OF_THE_YEAR);

    }






}

