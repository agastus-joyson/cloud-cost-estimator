package com.example.cloud_cost_estimator.repository;

import com.example.cloud_cost_estimator.models.EstimateRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstimateRequestRepository extends JpaRepository<EstimateRequest, Long> {

    List<EstimateRequest> findAllByOrderByTimestampDesc();
    
}
