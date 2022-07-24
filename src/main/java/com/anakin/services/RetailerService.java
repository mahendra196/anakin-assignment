package com.anakin.services;

import com.anakin.entities.Retailer;
import com.anakin.payloads.requests.AddRetailerRequest;
import com.anakin.payloads.requests.AddRetailerStoreRequest;
import com.anakin.payloads.responses.AddRetailerResponse;
import com.anakin.payloads.responses.AddRetailerStoreResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RetailerService {
    List<Retailer> getAllRetailers();
    AddRetailerResponse addRetailer(AddRetailerRequest addRetailerRequest);
    AddRetailerStoreResponse addStore(AddRetailerStoreRequest addRetailerStoreRequest);
}
