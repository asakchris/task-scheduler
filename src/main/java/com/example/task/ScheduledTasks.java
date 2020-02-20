package com.example.task;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss VV");

    @Value("${app.task.name}")
    private String name;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("Task: {}, The time is now {}", name, FORMATTER.format(ZonedDateTime.now()));
    }
}
