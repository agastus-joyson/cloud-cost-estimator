package com.example.cloud_cost_estimator.services;

import com.example.cloud_cost_estimator.repository.PricingDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {

    @Autowired
    private PricingDataRepository pricingDataRepository;

    public List<String> getResourceNamesByType(String type) {
        return pricingDataRepository.findDistinctResourceNamesByType(type);
    }

    public List<String> getRegionsByResource(String type, String name) {
        return pricingDataRepository.findDistinctRegionsByTypeAndName(type, name);
    }
}