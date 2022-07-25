package com.anakin.services;

import com.anakin.entities.User;
import com.anakin.payloads.requests.UserLoginRequest;
import com.anakin.payloads.requests.UserSignUpRequest;
import com.anakin.payloads.responses.UserLoginResponse;
import com.anakin.payloads.responses.UserSignUpResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    //UserDetails loadUserById(Integer id);
    UserSignUpResponse userSignUp(UserSignUpRequest userSignUpRequest);
    UserLoginResponse userLogin(UserLoginRequest userLoginRequest) throws Exception;
}
