package com.example.cloud_cost_estimator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstimateDetailsDTO {
    private Long id;
    private LocalDateTime timestamp;
    private Float totalCost;
    private List<ItemDetail> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ItemDetail {
        private String type;
        private String name;
        private String region;
        private Integer units;
        private Float unitCost;
        private Float totalCost;
    }
}
