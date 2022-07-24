package com.anakin.services.impl;

import com.anakin.entities.User;
import com.anakin.payloads.requests.UserLoginRequest;
import com.anakin.payloads.requests.UserSignUpRequest;
import com.anakin.payloads.responses.UserLoginResponse;
import com.anakin.payloads.responses.UserSignUpResponse;
import com.anakin.repositories.UserRepository;
import com.anakin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

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
            //TODO: add token
            userSignUpResponse.setToken("Bearer hhhhh3h3h3hhshis9jfdj0i0aj0hfao");
            userSignUpResponse.setMessage("SignedUp successfully");
        }
        else{
            userSignUpResponse.setMessage("userName already exists");
        }

        return userSignUpResponse;
    }

    @Override
    public UserLoginResponse userLogin(UserLoginRequest userLoginRequest){
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        if(userLoginRequest != null && userRepository.findByUserNameAndPassword(userLoginRequest.getUserName(), userLoginRequest.getPassword())!=null){
            //TODO: add token
            userLoginResponse.setToken("Bearer token");
            userLoginResponse.setMessage("Authenticated successfully");
        }
        else{
            userLoginResponse.setMessage("wrong userName or password");
        }
        return userLoginResponse;
    }
   /* public UserDetails loadUserById(Integer id) {
        User user = userRepository.findById(id).get();
        UserDetails userPrincipal = null;
        List<GrantedAuthority> authorities = Collections.
                singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        return new UserPrincipal(
                user.
                user.getEmail(),
                user.getPassword(),
                authorities
        );
        //Only for active users.
//		if(user.getIsActive().equals("1")){
        //UserPrincipal userPrincipal = UserPrincipal.create(user);
        //userPrincipal = UserPrincipal.create(user);
//		}
        return null;
    }*/
}
