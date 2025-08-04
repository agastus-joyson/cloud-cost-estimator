package com.example.cloud_cost_estimator.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pricing_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PricingData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resourceType;
    private String region;
    private Float unitCost;
}
