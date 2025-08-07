package com.example.cloud_cost_estimator.controllers;

import com.example.cloud_cost_estimator.dtos.EstimateDetailsDTO;
import com.example.cloud_cost_estimator.dtos.EstimateRequestDTO;
import com.example.cloud_cost_estimator.dtos.EstimateResponseDTO;
import com.example.cloud_cost_estimator.dtos.EstimateSummaryDTO;
import com.example.cloud_cost_estimator.services.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estimate")
@CrossOrigin
public class EstimateController {

    @Autowired
    private EstimateService estimateService;

    @PostMapping
    public EstimateResponseDTO createEstimate(@RequestBody EstimateRequestDTO requestDTO) {
        return estimateService.createEstimate(requestDTO);
    }

    @GetMapping("/history")
    public List<EstimateSummaryDTO> getEstimateHistory() {
        return estimateService.getEstimateHistory();
    }

    @GetMapping("/details")
    public EstimateDetailsDTO getEstimateDetails(@RequestParam Long id) {
        return estimateService.getEstimateDetails(id);
    }

}
