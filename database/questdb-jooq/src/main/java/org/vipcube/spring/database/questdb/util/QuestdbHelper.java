package org.vipcube.spring.database.questdb.util;

import java.time.OffsetDateTime;
import java.util.Objects;

public class QuestdbHelper {
    private QuestdbHelper() {
    }

    public static Long toInfluxTime(OffsetDateTime offsetDateTime) {
        return Objects.requireNonNull(offsetDateTime).toInstant().toEpochMilli() * 1000000;
    }

    public static Long toPostgresTime(OffsetDateTime offsetDateTime) {
        return Objects.requireNonNull(offsetDateTime).toInstant().toEpochMilli() * 1000;
    }
}
