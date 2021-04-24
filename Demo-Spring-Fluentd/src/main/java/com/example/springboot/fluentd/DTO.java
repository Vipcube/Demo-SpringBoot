package com.example.springboot.fluentd;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DTO {
    int id;
    String var;
    BigDecimal b;    
}
