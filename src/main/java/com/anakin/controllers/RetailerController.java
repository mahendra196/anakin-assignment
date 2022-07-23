package com.anakin.controllers;

import com.anakin.entities.Retailer;
import com.anakin.services.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/retailer")
public class RetailerController {
    @Autowired
    RetailerService retailerService;

    @GetMapping("/all")
    List<Retailer> getAllRetailers(){
        return retailerService.getAllRetailers();
    }

}
