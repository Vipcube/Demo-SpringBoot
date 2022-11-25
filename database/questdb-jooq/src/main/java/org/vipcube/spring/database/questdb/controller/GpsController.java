package org.vipcube.spring.database.questdb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vipcube.spring.database.questdb.entity.GpsRecord;
import org.vipcube.spring.database.questdb.repository.GpsRecordRepository;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/questdb/gps")
@RequiredArgsConstructor
public class GpsController {
    private final GpsRecordRepository repository;

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody GpsRecord gps) {
        return ResponseEntity.ok(repository.insert(gps));
    }

    @GetMapping("/{start}/{end}")
    public ResponseEntity<?> between(
            @PathVariable OffsetDateTime start,
            @PathVariable OffsetDateTime end) {
        return ResponseEntity.ok(repository.findByTimeRange(start, end));
    }
}
