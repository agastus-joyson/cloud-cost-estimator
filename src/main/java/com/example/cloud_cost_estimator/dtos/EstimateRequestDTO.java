package com.example.cloud_cost_estimator.dtos;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstimateRequestDTO {
    private String region;
    private List<ResourceInput> resources;

    @Data
    public static class ResourceInput {
        private String type;
        private Integer units;
    }
}
