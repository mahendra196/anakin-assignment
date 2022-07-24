package com.anakin.controllers;

import com.anakin.entities.Retailer;
import com.anakin.payloads.requests.AddRetailerRequest;
import com.anakin.payloads.requests.AddRetailerStoreRequest;
import com.anakin.payloads.responses.AddRetailerResponse;
import com.anakin.payloads.responses.AddRetailerStoreResponse;
import com.anakin.services.RetailerService;
import com.anakin.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public AddRetailerResponse addRetailer(@RequestHeader(name = "Authorization") String authToken, @RequestBody AddRetailerRequest addRetailerRequest){
        Integer userId = TokenUtil.getUserIdFromToken(authToken);
        addRetailerRequest.setUserId(userId);
        return retailerService.addRetailer(addRetailerRequest);
    }
    @PostMapping("/seller/add")
    public AddRetailerStoreResponse addStore(@RequestHeader(name = "Authorization") String authToken, @RequestBody AddRetailerStoreRequest addRetailerStoreRequest){
        Integer userId = TokenUtil.getUserIdFromToken(authToken);
        addRetailerStoreRequest.setUserId(userId);
        return retailerService.addStore(addRetailerStoreRequest);
    }

}
