package org.vipcube.spring.database.questdb.repository;

import org.vipcube.spring.database.questdb.entity.GpsRecord;

import java.time.OffsetDateTime;
import java.util.List;

public interface GpsRecordRepository {
    GpsRecord insert(GpsRecord entity);

    List<GpsRecord> findByTimeRange(OffsetDateTime since,
                                    OffsetDateTime until);
}
