package com.example.springboot.fluentd;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    Logger efk_logger = LoggerFactory.getLogger("efk-logger");

    @GetMapping("/fluentd-log")
    public String testThread() {
        // Test MDC
        MDC.put("hello", "here");
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if (attributes != null)
            attributes.setAttribute("Test", "abc", RequestAttributes.SCOPE_REQUEST);
        return Stream.of("a", "b", "c").parallel().peek(s -> {
            DTO data = DTO.builder().id(1).b(BigDecimal.valueOf(123)).var("a string").build();
            efk_logger.info(s + "/"
                    + Optional.ofNullable(RequestContextHolder.getRequestAttributes())
                            .map(attrs -> attrs.getAttribute("Test", RequestAttributes.SCOPE_REQUEST))
                            .orElse("no-request-contexxt")
                    + "/" + MDC.get("hello"), data);
        }).collect(Collectors.joining());
    }
}
