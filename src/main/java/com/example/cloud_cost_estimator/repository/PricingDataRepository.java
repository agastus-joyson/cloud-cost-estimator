package com.example.cloud_cost_estimator.repository;

import com.example.cloud_cost_estimator.models.PricingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PricingDataRepository extends JpaRepository<PricingData, Long> {

    @Query("SELECT DISTINCT p.resourceType FROM PricingData p WHERE p.region = :region")
    List<String> findDistinctResourceTypesByRegion(String region);

    @Query("SELECT DISTINCT p.region FROM PricingData p")
    List<String> findDistinctRegions();

    Optional<PricingData> findByResourceTypeAndRegion(String resourceType, String region);
}
