package com.example.cloud_cost_estimator.services;

import com.example.cloud_cost_estimator.dtos.EstimateRequestDTO;
import com.example.cloud_cost_estimator.dtos.EstimateResponseDTO;
import com.example.cloud_cost_estimator.dtos.EstimateResponseDTO.ResourceBreakdown;
import com.example.cloud_cost_estimator.models.PricingData;
import com.example.cloud_cost_estimator.repository.PricingDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PricingService {

    @Autowired
    private PricingDataRepository pricingDataRepository;

    public List<String> getAllResourceTypes() {
        return pricingDataRepository.findDistinctResourceTypes();
    }

    public List<String> getAllRegions() {
        return pricingDataRepository.findDistinctRegions();
    }
}
