package com.anakin.services.impl;

import com.anakin.entities.User;
import com.anakin.payloads.requests.UserLoginRequest;
import com.anakin.payloads.requests.UserSignUpRequest;
import com.anakin.payloads.responses.UserLoginResponse;
import com.anakin.payloads.responses.UserSignUpResponse;
import com.anakin.repositories.UserRepository;
import com.anakin.security.JwtTokenUtil;
import com.anakin.security.JwtUserDetailsService;
import com.anakin.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Autowired
    private JwtUserDetailsService userDetailsService;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserSignUpResponse userSignUp(UserSignUpRequest userSignUpRequest){
        UserSignUpResponse userSignUpResponse = new UserSignUpResponse();
        if(userRepository.findByUserName(userSignUpRequest.getUserName()) == null){
            User user = new User();
            user.setName(userSignUpRequest.getName());
            user.setUserName(userSignUpRequest.getUserName());
            user.setEmail(userSignUpRequest.getEmail());
            user.setPassword(userSignUpRequest.getPassword());
            userRepository.save(user);
            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(userSignUpRequest.getUserName());

            final String token = jwtTokenUtil.generateToken(userDetails);
            userSignUpResponse.setToken(token);
            userSignUpResponse.setMessage("SignedUp successfully");
        }
        else{
            userSignUpResponse.setMessage("userName already exists");
        }

        return userSignUpResponse;
    }

    @Override
    public UserLoginResponse userLogin(UserLoginRequest userLoginRequest) throws Exception{
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword =bCryptPasswordEncoder.encode(userLoginRequest.getPassword());
        logger.info("Encoded password:"+encodedPassword);
        authenticate(userLoginRequest.getUserName(), userLoginRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(userLoginRequest.getUserName());
        final String token = jwtTokenUtil.generateToken(userDetails);

        userLoginResponse.setToken(token);
        userLoginResponse.setMessage("Authenticated successfully");

        return userLoginResponse;
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
