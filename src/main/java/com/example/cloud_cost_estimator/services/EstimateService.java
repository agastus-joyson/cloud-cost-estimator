package com.example.cloud_cost_estimator.services;

import com.example.cloud_cost_estimator.dtos.EstimateRequestDTO;
import com.example.cloud_cost_estimator.dtos.EstimateResponseDTO;
import com.example.cloud_cost_estimator.dtos.EstimateSummaryDTO;
import com.example.cloud_cost_estimator.models.EstimateItem;
import com.example.cloud_cost_estimator.models.EstimateRequest;
import com.example.cloud_cost_estimator.models.PricingData;
import com.example.cloud_cost_estimator.repository.EstimateRequestRepository;
import com.example.cloud_cost_estimator.repository.PricingDataRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstimateService {

    @Autowired
    private PricingDataRepository pricingDataRepository;

    @Autowired
    private EstimateRequestRepository estimateRequestRepository;

    @Transactional
    public EstimateResponseDTO createEstimate(EstimateRequestDTO requestDTO) {
        List<EstimateResponseDTO.ResourceBreakdown> breakdownList = new ArrayList<>();
        List<EstimateItem> estimateItems = new ArrayList<>();
        float totalCost = 0f;

        for (EstimateRequestDTO.ResourceInput input : requestDTO.getResources()) {
            PricingData pricingData = pricingDataRepository
                    .findByResourceTypeAndRegion(input.getType(), requestDTO.getRegion())
                    .orElseThrow(() -> new RuntimeException("Pricing not found for resource: "
                            + input.getType() + " in region: " + requestDTO.getRegion()));

            float itemCost = pricingData.getUnitCost() * input.getUnits();

            breakdownList.add(new EstimateResponseDTO.ResourceBreakdown(
                    input.getType(),
                    input.getUnits(),
                    pricingData.getUnitCost(),
                    itemCost
            ));

            EstimateItem item = new EstimateItem();
            item.setResourceType(input.getType());
            item.setUnits(input.getUnits());
            item.setUnitCost(pricingData.getUnitCost());
            item.setTotalCost(itemCost);
            estimateItems.add(item);

            totalCost += itemCost;
        }

        EstimateRequest estimateRequest = new EstimateRequest();
        estimateRequest.setRegion(requestDTO.getRegion());
        estimateRequest.setTimestamp(LocalDateTime.now());
        estimateRequest.setTotalCost(totalCost);
        for (EstimateItem item : estimateItems) {
            item.setEstimateRequest(estimateRequest);
        }
        estimateRequest.setItems(estimateItems);
        estimateRequestRepository.save(estimateRequest);

        return new EstimateResponseDTO(totalCost, breakdownList);
    }

    public List<EstimateSummaryDTO> getEstimateHistory() {
        return estimateRequestRepository.findAllByOrderByTimestampDesc().stream()
                .map(e -> new EstimateSummaryDTO(
                        e.getId(),
                        e.getRegion(),
                        e.getTotalCost(),
                        e.getTimestamp()
                ))
                .toList();
    }
}
