package com.pw.airbnb.service.auth;

import com.pw.airbnb.dto.SignupRequest;
import com.pw.airbnb.dto.UserDto;

public interface AuthService {
    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);
}
