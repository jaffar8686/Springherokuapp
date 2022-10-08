package com.example.heroku.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchedulerData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String scheduledType;
    private LocalDateTime localDateTime;
    private String localDateTimeWithZoneId;
}
