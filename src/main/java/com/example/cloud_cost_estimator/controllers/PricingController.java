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

    @GetMapping("/names")
    public List<String> getResourceNames(@RequestParam String type) {
        return pricingService.getResourceNamesByType(type);
    }

    @GetMapping("/regions")
    public List<String> getRegionsForResource(@RequestParam String type, @RequestParam String name) {
        return pricingService.getRegionsByResource(type, name);
    }
}
