package com.anakin.controllers;

import com.anakin.models.JwtRequest;
import com.anakin.models.JwtResponse;
import com.anakin.payloads.requests.UserLoginRequest;
import com.anakin.payloads.requests.UserSignUpRequest;
import com.anakin.payloads.responses.UserLoginResponse;
import com.anakin.payloads.responses.UserSignUpResponse;
import com.anakin.security.JwtTokenUtil;
import com.anakin.security.JwtUserDetailsService;
import com.anakin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/signup")
    public UserSignUpResponse userSignUp(@RequestBody UserSignUpRequest userSignUpRequest){
        return userService.userSignUp(userSignUpRequest);
    }
    @PostMapping("/login")
    public UserLoginResponse userLogin(@RequestBody UserLoginRequest userLoginRequest) throws Exception{

        return userService.userLogin(userLoginRequest);
    }
}
