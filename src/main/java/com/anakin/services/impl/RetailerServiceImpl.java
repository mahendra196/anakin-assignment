package com.anakin.services.impl;

import com.anakin.entities.Address;
import com.anakin.entities.Retailer;
import com.anakin.entities.Store;
import com.anakin.payloads.requests.AddRetailerRequest;
import com.anakin.payloads.requests.AddRetailerStoreRequest;
import com.anakin.payloads.responses.AddRetailerResponse;
import com.anakin.payloads.responses.AddRetailerStoreResponse;
import com.anakin.repositories.AddressRepository;
import com.anakin.repositories.RetailerRepository;
import com.anakin.repositories.StoreRepository;
import com.anakin.services.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class RetailerServiceImpl implements RetailerService {
    @Autowired
    RetailerRepository retailerRepository;
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    AddressRepository addressRepository;
    @Override
    public List<Retailer> getAllRetailers(){
        return retailerRepository.findAll();
    }
    @Override
    public AddRetailerResponse addRetailer(AddRetailerRequest addRetailerRequest){
        Retailer retailer=new Retailer(addRetailerRequest);
        retailer=retailerRepository.save(retailer);
        AddRetailerResponse addRetailerResponse = new AddRetailerResponse(retailer);
        return addRetailerResponse;
    }
    @Override
    @Transactional(rollbackOn = Exception.class)
    public AddRetailerStoreResponse addStore(AddRetailerStoreRequest addRetailerStoreRequest){
        addRetailerStoreRequest.setStatusId(1);
        Address address = new Address(addRetailerStoreRequest.getAddressDTO());
        address=addressRepository.save(address);
        addRetailerStoreRequest.setAddress(address);
        Store store = new Store(addRetailerStoreRequest);
        store = storeRepository.save(store);
        return new AddRetailerStoreResponse(store);
    }


}
