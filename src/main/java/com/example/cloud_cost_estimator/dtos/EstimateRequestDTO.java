package com.example.cloud_cost_estimator.dtos;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstimateRequestDTO {
    private List<ResourceEstimateInput> resources;

    @Data
    public static class ResourceEstimateInput {
        private String type;
        private String name;
        private String region;
        private Integer units;
    }
}
