package com.example.heroku.service;

import com.example.heroku.model.SchedulerData;
import com.example.heroku.repository.SchedulerDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SchedulerDataService {

    @Autowired
    private SchedulerDataRepository schedulerDataRepository;

    public void saveSchedulerDetails(String schedulerType){


        DateTimeFormatter formatTodayWithZoneId = DateTimeFormatter.ofPattern("MM/dd/yy hh:mm:ss Z");
        LocalDateTime today = LocalDateTime.now();
        ZoneId zone = ZoneId.of("Asia/Kolkata");
        ZonedDateTime todayWithTimeZone = ZonedDateTime.of(today,zone);
        String formattedDateWithZone = todayWithTimeZone.format(formatTodayWithZoneId);

        SchedulerData schedulerData = new SchedulerData();
        schedulerData.setScheduledType(schedulerType);
        schedulerData.setLocalDateTime(LocalDateTime.now());
        schedulerData.setLocalDateTimeWithZoneId(formattedDateWithZone);
        schedulerDataRepository.save(schedulerData);

    }

    public List<SchedulerData> getAllSchedulerData(){
        return schedulerDataRepository.findAll();
    }

    public void deleteAllData() {
        schedulerDataRepository.deleteAll();
    }
}
