package com.example.cloud_cost_estimator.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.time.LocalDateTime;

@Entity
@Table(name = "estimate_request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstimateRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    private Float totalCost;
    @OneToMany(mappedBy = "estimateRequest", cascade = CascadeType.ALL)
    private List<EstimateItem> items;
}
