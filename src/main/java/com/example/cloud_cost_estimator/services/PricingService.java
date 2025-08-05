package com.example.cloud_cost_estimator.services;

import com.example.cloud_cost_estimator.repository.PricingDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {

    @Autowired
    private PricingDataRepository pricingDataRepository;

    public List<String> getResourceTypesByRegion(String region) {
        return pricingDataRepository.findDistinctResourceTypesByRegion(region);
    }

    public List<String> getAllRegions() {
        return pricingDataRepository.findDistinctRegions();
    }
}
