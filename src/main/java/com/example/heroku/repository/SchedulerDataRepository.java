package com.example.heroku.repository;

import com.example.heroku.model.SchedulerData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerDataRepository extends JpaRepository<SchedulerData,Long> {
}
