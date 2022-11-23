package org.vipcube.spring.trace.otel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DemoController {
  @GetMapping("/")
  public String home() {
    log.info("Handling home");
    return "Hello World";
  }
}
