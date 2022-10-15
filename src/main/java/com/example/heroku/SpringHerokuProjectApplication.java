package com.example.heroku;

import com.example.heroku.model.SchedulerData;
import com.example.heroku.repository.SchedulerDataRepository;
import com.example.heroku.service.SchedulerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SpringHerokuProjectApplication {

	@Autowired
	private SchedulerDataRepository schedulerDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringHerokuProjectApplication.class, args);
	}

	@PostConstruct
	public void getCurrentTimeZone(){

		DateFormat DFormat = DateFormat.getDateInstance();
		String str = DFormat.format(new Date());
		System.out.println(DFormat.getTimeZone().getDisplayName());

		SchedulerData data = new SchedulerData();
		data.setScheduledType("Running Every Start Of Application");
		data.setLocalDateTime(LocalDateTime.now());
		data.setLocalDateTimeWithZoneId(DFormat.getTimeZone().getDisplayName());
		schedulerDataRepository.save(data);

		//Setting Timezone
		DateTimeFormatter formatTodayWithZoneId = DateTimeFormatter.ofPattern("MM/dd/yy hh:mm:ss Z");
		LocalDateTime today = LocalDateTime.now();
		ZoneId zone = ZoneId.of("Asia/Kolkata");
		ZonedDateTime todayWithTimeZone = ZonedDateTime.of(today,zone);
		String formattedDate = todayWithTimeZone.format(formatTodayWithZoneId);
		System.out.println("Formatted date with time zone "+ " "+todayWithTimeZone.format(formatTodayWithZoneId));



	}

}


