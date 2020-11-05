package com.example;

import com.example.task.AppConfig;
import com.example.task.ScheduledTasks;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.Duration;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringJUnitConfig(AppConfig.class)
//@SpringBootTest
public class ApplicationIntegrationTest {
    @SpyBean
    private ScheduledTasks scheduledTasks;

    //@Test
    public void whenWaitOneSecond_thenScheduledIsCalledAtLeastTenTimes() {
        await()
                .atMost(Duration.ofSeconds(12))
                .untilAsserted(() -> verify(scheduledTasks, atLeast(2)).job1());
    }
}