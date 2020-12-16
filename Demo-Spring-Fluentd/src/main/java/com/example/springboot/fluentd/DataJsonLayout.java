package com.example.springboot.fluentd;

import java.util.Map;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.contrib.json.classic.JsonLayout;

public class DataJsonLayout extends JsonLayout {
    @Override
    protected void addCustomDataToJsonMap(Map<String, Object> map, ILoggingEvent event) {
        // Nothing to do in default implementation
        Object[] data = event.getArgumentArray();
        if (data.length > 0)
            map.put("data", data[0]);
        if (data.length > 1) {
            for (int i = 1; i < data.length; i++) {
                map.put("data" + i, data[i]);
            }
        }
    }
}
