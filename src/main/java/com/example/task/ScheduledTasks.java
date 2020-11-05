package com.example.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTasks {
  private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
  private static final DateTimeFormatter FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss VV");

  @Value("${app.task.name}")
  private String name;

  @Scheduled(initialDelay = 1000, fixedDelay = 5000)
  public void job1() throws InterruptedException {
    log.info("1 - start: {}", FORMATTER.format(ZonedDateTime.now()));
    Thread.sleep(6000);
    log.info("1 - end: {}", FORMATTER.format(ZonedDateTime.now()));
  }

  @Scheduled(initialDelay = 1000, fixedDelay = 1000)
  public void job2() throws InterruptedException {
    log.info("2 - start: {}", FORMATTER.format(ZonedDateTime.now()));
    Thread.sleep(2000);
    log.info("2 - end: {}", FORMATTER.format(ZonedDateTime.now()));
  }
}
