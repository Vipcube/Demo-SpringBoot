package org.vipcube.spring.database.questdb.repository.impl;

import io.questdb.client.Sender;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.conf.ParamType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.vipcube.spring.database.questdb.entity.GpsRecord;
import org.vipcube.spring.database.questdb.repository.GpsRecordRepository;
import org.vipcube.spring.database.questdb.util.QuestdbDSL;
import org.vipcube.spring.database.questdb.util.QuestdbHelper;

import java.time.OffsetDateTime;
import java.util.List;

import static org.vipcube.spring.database.questdb.entity.GpsRecord.GPS_RECORD;

@Repository
@RequiredArgsConstructor
public class GpsRecordRepositoryImpl implements GpsRecordRepository {
    private final DSLContext dslContext;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Value("${questdb.address}")
    private String address;

    @Value("${questdb.user}")
    private String user;

    @Value("${questdb.token}")
    private String token;

    @Override
    public GpsRecord insert(GpsRecord entity) {
        try (Sender sender = Sender.builder().address(address).enableAuth(user).authToken(token).build()) {
            sender.symbol(GPS_RECORD.DEVICE.getName(), entity.getDevice())
                    .doubleColumn(GPS_RECORD.LAT.getName(), entity.getLat())
                    .doubleColumn(GPS_RECORD.LON.getName(), entity.getLon())
                    .at(QuestdbHelper.toInfluxTime(entity.getTimestamp()));
        }
        return entity;
    }

    @Override
    public List<GpsRecord> findByTimeRange(OffsetDateTime since, OffsetDateTime until) {
        var query =
                dslContext
                        .select(
                                GPS_RECORD.DEVICE,
                                QuestdbDSL.last(GPS_RECORD.LON)
                                        .as(GPS_RECORD.LON.getName()),
                                QuestdbDSL.last(GPS_RECORD.LAT)
                                        .as(GPS_RECORD.LAT.getName()),
                                GPS_RECORD.TIMESTAMP)
                        .from(GPS_RECORD)
                        .where(List.of(
                                GPS_RECORD.TIMESTAMP.ge(since),
                                GPS_RECORD.TIMESTAMP.lt(until)
                        ));
        var sql = query.getSQL(ParamType.INLINED);
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(GpsRecord.class));
    }
}
