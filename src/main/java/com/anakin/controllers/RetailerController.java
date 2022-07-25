package com.anakin.controllers;

import com.anakin.entities.Retailer;
import com.anakin.entities.User;
import com.anakin.payloads.requests.AddRetailerRequest;
import com.anakin.payloads.requests.AddRetailerStoreRequest;
import com.anakin.payloads.responses.AddRetailerResponse;
import com.anakin.payloads.responses.AddRetailerStoreResponse;
import com.anakin.repositories.UserRepository;
import com.anakin.security.JwtTokenUtil;
import com.anakin.services.RetailerService;
import com.anakin.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/retailer")
public class RetailerController {
    @Autowired
    RetailerService retailerService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    Logger logger = LoggerFactory.getLogger(RetailerController.class);

    @GetMapping("/all")
    List<Retailer> getAllRetailers(){
        return retailerService.getAllRetailers();
    }

    @PostMapping("/add")
    public AddRetailerResponse addRetailer(@RequestHeader(name = "Authorization") String authToken, @RequestBody AddRetailerRequest addRetailerRequest){
        String jwtToken = jwtTokenUtil.getJwtTokenString(authToken);
        String userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
        User user = userRepository.findByUserName(userName);
        logger.debug(authToken);
        addRetailerRequest.setUserId(user.getUserId());
        return retailerService.addRetailer(addRetailerRequest);
    }
    @PostMapping("/seller/add")
    public AddRetailerStoreResponse addStore(@RequestHeader(name = "Authorization") String authToken, @RequestBody AddRetailerStoreRequest addRetailerStoreRequest){
        String jwtToken = jwtTokenUtil.getJwtTokenString(authToken);
        String userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
        User user = userRepository.findByUserName(userName);
        logger.debug(authToken);
        addRetailerStoreRequest.setUserId(user.getUserId());
        return retailerService.addStore(addRetailerStoreRequest);
    }

}
