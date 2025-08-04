package com.example.cloud_cost_estimator.repository;

import com.example.cloud_cost_estimator.models.EstimateItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimateItemRepository extends JpaRepository<EstimateItem, Long> {

}
