package org.vipcube.spring.database.questdb.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.QuestDBContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.vipcube.spring.database.questdb.entity.GpsRecord;

import java.time.OffsetDateTime;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GpsRecordRepositoryTest {
    private static QuestDBContainer container;
    private static OffsetDateTime now;
    @Autowired
    private GpsRecordRepository repository;

    @BeforeAll
    public static void init() {
        container =
                new QuestDBContainer("questdb/questdb:6.5.4")
                        .withReuse(true)
                        .withLogConsumer(new Slf4jLogConsumer(log));
        container.start();

        now = OffsetDateTime.now();
    }

    @AfterAll
    public static void finished() {
        container.stop();
    }

    @DynamicPropertySource
    public static void injectProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.driver-class-name", container::getDriverClassName);
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("questdb.address", container::getIlpUrl);
    }

    @Test
    @Order(1)
    public void testCreate() {
        var entity =
                GpsRecord.builder()
                        .device("AIR_TAG")
                        .lat(30)
                        .lon(120)
                        .timestamp(now)
                        .build();

        repository.insert(entity);
    }

    @Test
    @Order(2)
    public void testSampleGeolocationRecords() {
        var entities =
                repository.findByTimeRange(
                        now.minusHours(1), now.plusHours(1));
        Assertions.assertFalse(entities.isEmpty());
    }
}
