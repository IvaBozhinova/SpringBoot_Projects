package com.example.mobilele.service;


import com.example.mobilele.model.UserLoginDTO;
import com.example.mobilele.model.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistration);

    boolean login(UserLoginDTO userLoginDTO);

    void logout();
}