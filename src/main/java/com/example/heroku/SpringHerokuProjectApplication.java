package com.example.heroku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.util.Date;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SpringHerokuProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHerokuProjectApplication.class, args);
	}

	@PostConstruct
	public void getCurrentTimeZone(){

		DateFormat DFormat = DateFormat.getDateInstance();

		String str = DFormat.format(new Date());

		System.out.println(DFormat.getTimeZone().getDisplayName());
	}

}


