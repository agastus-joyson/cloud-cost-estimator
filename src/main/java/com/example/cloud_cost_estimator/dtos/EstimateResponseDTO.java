package com.example.cloud_cost_estimator.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstimateResponseDTO {
    private Float totalCost;
    private List<ResourceBreakdown> breakdown;

    @Data
    @AllArgsConstructor
    public static class ResourceBreakdown {
        private String type;
        private String name;
        private String region;
        private Integer units;
        private Float unitCost;
        private Float cost;
    }
}
