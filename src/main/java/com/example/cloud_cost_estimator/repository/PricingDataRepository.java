package com.example.cloud_cost_estimator.repository;

import com.example.cloud_cost_estimator.models.PricingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PricingDataRepository extends JpaRepository<PricingData, Long> {

    @Query("SELECT DISTINCT p.resource.name FROM PricingData p WHERE p.resource.type = :type")
    List<String> findDistinctResourceNamesByType(String type);

    @Query("SELECT DISTINCT p.region FROM PricingData p WHERE p.resource.type = :type AND p.resource.name = :name")
    List<String> findDistinctRegionsByTypeAndName(String type, String name);

    @Query("SELECT p FROM PricingData p WHERE p.resource.type = :type AND p.resource.name = :name AND p.region = :region")
    Optional<PricingData> findByResourceDetails(String type, String name, String region);
}
