package org.vipcube.spring.database.questdb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jooq.TableField;
import org.jooq.impl.CustomRecord;
import org.jooq.impl.CustomTable;
import org.jooq.impl.SQLDataType;

import java.time.OffsetDateTime;

import static org.jooq.impl.DSL.name;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GpsRecord {
    public static final Table GPS_RECORD = new Table();

    private String device;
    private double lon;
    private double lat;
    private OffsetDateTime timestamp;

    public static class Table extends CustomTable<Record> {
        public final TableField<Record, String> DEVICE =
                createField(name("device"), SQLDataType.VARCHAR, this);
        public final TableField<Record, Double> LON =
                createField(name("lon"), SQLDataType.DOUBLE, this);
        public final TableField<Record, Double> LAT =
                createField(name("lat"), SQLDataType.DOUBLE, this);
        public final TableField<Record, OffsetDateTime> TIMESTAMP =
                createField(name("timestamp"), SQLDataType.OFFSETDATETIME, this);

        protected Table() {
            super(name("iot-gps"));
        }

        @Override
        public Class<? extends Record> getRecordType() {
            return Record.class;
        }
    }

    private static class Record extends CustomRecord<Record> {
        protected Record() {
            super(GpsRecord.GPS_RECORD);
        }
    }
}
