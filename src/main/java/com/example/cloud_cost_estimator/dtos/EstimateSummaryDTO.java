package com.example.cloud_cost_estimator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EstimateSummaryDTO {
    private Long id;
    private String region;
    private Float totalCost;
    private LocalDateTime timestamp;
}
