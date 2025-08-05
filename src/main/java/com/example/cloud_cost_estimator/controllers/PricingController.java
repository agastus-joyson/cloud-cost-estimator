package com.example.cloud_cost_estimator.controllers;

import com.example.cloud_cost_estimator.services.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricing")
@CrossOrigin
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @GetMapping("/resources")
    public List<String> getAllResourceTypes() {
        return pricingService.getAllResourceTypes();
    }

    @GetMapping("/regions")
    public List<String> getAllRegions() {
        return pricingService.getAllRegions();
    }
}
